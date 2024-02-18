package com.khit.recruit.entity;

import com.khit.recruit.dto.JobDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Currency;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Noti extends BaseEntity{
	
	@Id
	@Column(name = "noti_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String content;
	
	@Column
	private Integer likes;
	
	@Column
	private Integer views;


	
}
