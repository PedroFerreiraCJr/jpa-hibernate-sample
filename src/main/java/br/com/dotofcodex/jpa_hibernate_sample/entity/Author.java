package br.com.dotofcodex.jpa_hibernate_sample.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String surname;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthday;

	@ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
	private Set<Book> books;

	public Author() {
		super();
	}

}
