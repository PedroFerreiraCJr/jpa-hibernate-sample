package br.com.dotofcodex.jpa_hibernate_sample;

import br.com.dotofcodex.jpa_hibernate_sample.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		JPAUtil.getEntityManagerFactory().close();
		JPAUtil.shutdown();
	}

}
