package co.sabit.schedulerapplicationspringboot.configuration;

import co.sabit.adapter.TaskCommand;
import co.sabit.adapter.TaskQuery;
import co.sabit.adapter.input.program.UuidGeneratorInterpreterWeb;
import co.sabit.adapter.output.program.TaskCreateInterpreterPersistence;
import co.sabit.adapter.output.program.TaskQueryInterpreterPersistence;
import co.sabit.adapter.output.program.TaskUpdateInterpreterPersistence;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.adapter.output.repository.TaskQueryRepository;
import co.sabit.core.port.input.IdGeneratorAlgebra;
import co.sabit.core.port.output.CreateTaskAlgebra;
import co.sabit.core.port.output.QueryTaskAlgebra;
import co.sabit.core.port.output.UpdateTaskAlgebra;
import co.sabit.core.usecase.TaskValidatorAlgebra;
import co.sabit.core.usecase.program.TaskCommandInterpreter;
import co.sabit.core.usecase.program.TaskQueryInterpreter;
import co.sabit.core.usecase.program.TaskValidatorInterpreter;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
public class SchedulerConfiguration {
    private static final String[] ENTITY_MANAGER_PACKAGES_TO_SCAN = {"co.sabit.adapter.output.model"};

    private Properties jpaHibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.id.new_generator_mappings", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }

    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final DataSource dataSource = dataSource();
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(ENTITY_MANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean(name = "taskQueryRepository")
    public TaskQueryRepository taskQueryRepository(EntityManager entityManager) {
        return new TaskQueryRepository(entityManager);
    }

    @Bean(name = "taskCommandRepository")
    public TaskCommandRepository taskCommandRepository(EntityManager entityManager) {
        return new TaskCommandRepository(entityManager);
    }

    @Bean(name = "queryTaskRepository")
    public QueryTaskAlgebra queryTaskRepository(TaskQueryRepository taskQueryRepository) {
        return new TaskQueryInterpreterPersistence(taskQueryRepository);
    }

    @Bean(name = "createTaskRepository")
    public CreateTaskAlgebra createTaskRepository(TaskCommandRepository taskCommandRepository) {
        return new TaskCreateInterpreterPersistence(taskCommandRepository);
    }

    @Bean(name = "updateTaskRepository")
    public UpdateTaskAlgebra updateTaskRepository(TaskCommandRepository taskCommandRepository) {
        return new TaskUpdateInterpreterPersistence(taskCommandRepository);
    }

    @Bean(name = "taskValidatorUseCase")
    public TaskValidatorAlgebra taskValidatorUseCase(QueryTaskAlgebra queryTaskAlgebra) {
        return new TaskValidatorInterpreter(queryTaskAlgebra);
    }

    @Bean(name = "idGeneratorService")
    public IdGeneratorAlgebra idGeneratorService() {
        return new UuidGeneratorInterpreterWeb();
    }

    @Bean(name = "taskQueryService")
    public TaskQueryInterpreter taskQueryService(QueryTaskAlgebra queryTaskAlgebra) {
        return new TaskQueryInterpreter(queryTaskAlgebra);
    }

    @Bean(name = "taskProgramCommand")
    public TaskCommand taskProgramCommand(CreateTaskAlgebra createTaskAlgebra, UpdateTaskAlgebra updateTaskAlgebra, TaskValidatorAlgebra taskValidatorAlgebra, IdGeneratorAlgebra idGeneratorAlgebra) {
        return new TaskCommand(new TaskCommandInterpreter(createTaskAlgebra, updateTaskAlgebra, taskValidatorAlgebra, idGeneratorAlgebra));
    }

    @Bean(name = "taskProgramQuery")
    public TaskQuery taskProgramQuery(TaskQueryInterpreter taskQueryInterpreter) {
        return new TaskQuery(taskQueryInterpreter);
    }
}
