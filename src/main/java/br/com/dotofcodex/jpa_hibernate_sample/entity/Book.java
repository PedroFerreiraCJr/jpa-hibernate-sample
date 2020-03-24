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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "books_authors",
		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id")
	)
	private Set<Author> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "books_revisors",
		joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "revisor_id", referencedColumnName = "id")
	)
	private Set<Revisor> revisors;
	
	public Book() {
		super();
	}
}
