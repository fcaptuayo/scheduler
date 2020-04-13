package co.sabit.adapter.output.model;

import javax.persistence.*;

@Entity
@Table(name = "responsibles")
public class ResponsibleJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsible_id")
    private Long id;

    @Column(name = "nickname", length = 200, nullable = false)
    private String nickname;

    public ResponsibleJpaEntity() {
    }

    public ResponsibleJpaEntity(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
