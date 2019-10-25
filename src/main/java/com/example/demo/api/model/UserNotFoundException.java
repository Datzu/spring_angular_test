package com.example.demo.api.model;

public class UserNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
        super("Book id not found : " + id);
    }

}
