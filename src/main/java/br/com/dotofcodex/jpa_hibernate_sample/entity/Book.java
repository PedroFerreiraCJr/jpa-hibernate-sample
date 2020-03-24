package br.com.dotofcodex.jpa_hibernate_sample.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.dotofcodex.jpa_hibernate_sample.types.BookType;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String title;

	@Column(nullable = false, length = 255)
	private String subtitle;

	@Column(nullable = false, length = 100)
	private String isbn;

	@Column(nullable = false)
	private Integer pages;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BookType type;

	@Column(name = "publish_date", nullable = true)
	private Date publishDate;

	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private Set<Author> authors;

	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private Set<Revisor> revisors;

	public Book() {
		super();
	}
}
