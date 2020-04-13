package co.sabit.schedulerapplicationspringboot.configuration;

import co.sabit.adapter.TaskProgramCommand;
import co.sabit.adapter.TaskProgramQuery;
import co.sabit.adapter.input.UuidGeneratorAdapterInput;
import co.sabit.adapter.output.TaskCreateAdapterOutput;
import co.sabit.adapter.output.TaskQueryAdapterOutput;
import co.sabit.adapter.output.TaskUpdateAdapterOutput;
import co.sabit.adapter.output.repository.TaskCommandRepository;
import co.sabit.adapter.output.repository.TaskQueryRepository;
import co.sabit.core.port.input.IdGeneratorPortInput;
import co.sabit.core.port.output.CreateTaskPortOutput;
import co.sabit.core.port.output.QueryTaskPortOutput;
import co.sabit.core.port.output.UpdateTaskPortOutput;
import co.sabit.core.usecase.TaskValidatorUseCase;
import co.sabit.core.usecase.service.TaskCommandService;
import co.sabit.core.usecase.service.TaskQueryService;
import co.sabit.core.usecase.service.TaskValidatorService;
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
    public QueryTaskPortOutput queryTaskRepository(TaskQueryRepository taskQueryRepository) {
        return new TaskQueryAdapterOutput(taskQueryRepository);
    }

    @Bean(name = "createTaskRepository")
    public CreateTaskPortOutput createTaskRepository(TaskCommandRepository taskCommandRepository) {
        return new TaskCreateAdapterOutput(taskCommandRepository);
    }

    @Bean(name = "updateTaskRepository")
    public UpdateTaskPortOutput updateTaskRepository(TaskCommandRepository taskCommandRepository) {
        return new TaskUpdateAdapterOutput(taskCommandRepository);
    }

    @Bean(name = "taskValidatorUseCase")
    public TaskValidatorUseCase taskValidatorUseCase(QueryTaskPortOutput queryTaskPortOutput) {
        return new TaskValidatorService(queryTaskPortOutput);
    }

    @Bean(name = "idGeneratorService")
    public IdGeneratorPortInput idGeneratorService() {
        return new UuidGeneratorAdapterInput();
    }

    @Bean(name = "taskQueryService")
    public TaskQueryService taskQueryService(QueryTaskPortOutput queryTaskPortOutput) {
        return new TaskQueryService(queryTaskPortOutput);
    }

    @Bean(name = "taskProgramCommand")
    public TaskProgramCommand taskProgramCommand(CreateTaskPortOutput createTaskPortOutput, UpdateTaskPortOutput updateTaskPortOutput, TaskValidatorUseCase taskValidatorUseCase, IdGeneratorPortInput idGeneratorPortInput) {
        return new TaskProgramCommand(new TaskCommandService(createTaskPortOutput, updateTaskPortOutput, taskValidatorUseCase, idGeneratorPortInput));
    }

    @Bean(name = "taskProgramQuery")
    public TaskProgramQuery taskProgramQuery(TaskQueryService taskQueryService) {
        return new TaskProgramQuery(taskQueryService);
    }
}
