package com.easytrip.easytrip.payload.response;

import java.util.List;

public class JwtResponse {
    private final List<String> roles;
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String description;

    public JwtResponse(String accessToken, Long id, String username, String email, String description, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.description = description;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<String> getRoles() {
		return roles;
	}
}
