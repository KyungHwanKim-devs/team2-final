package com.khit.recruit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String content;

	@Column
	private String author;

	@Column
	private String avatarURL;

//	@JsonIgnore
//	@ManyToOne(fetch = LAZY)
//	@JoinColumn(name = "users_id")
//	private Users users;



	
}
