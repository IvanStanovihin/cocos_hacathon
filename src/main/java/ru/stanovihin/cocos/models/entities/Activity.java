package ru.stanovihin.cocos.models.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Integer distance;
    private Integer intensity;
    private String date;
    private String createDate;
    private Integer steps;
    private Integer calories;
    private String image;
    private Integer duration;
    private Integer coinsReceived;
    private Integer averageSpeed;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cocos_user_id")
    private CocosUser cocosUser;
}
