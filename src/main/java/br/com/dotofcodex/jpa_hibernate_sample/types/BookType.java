package br.com.dotofcodex.jpa_hibernate_sample.types;

public enum BookType {
	EBOOK("Ebook"), PHYSICAL("Physical");

	private String type;

	private BookType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
