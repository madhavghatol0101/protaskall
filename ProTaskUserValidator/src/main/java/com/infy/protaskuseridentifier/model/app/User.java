package com.infy.protaskuseridentifier.model.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userIdentifier;		
	
	@Size(max = 20, min = 3, message = "Invalid Name, Size should be between 3 to 20")
    @NotEmpty(message = "Please enter your name")
	private String userName;
	
	@NotEmpty
    @Pattern(regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}", 
            message="Please provide a valid email address")    
 	private String emailAddress;	
	
	@NotNull
	@Size(min=4, max=50)        
	private String firstName;
	
	@NotNull
	@Size(min=4, max=50)
	private String lastName;
	
	@Range(min = 1, max = 10, message = "Invalid Range is given, Range should be within 1 to 10")
	private long contactNumber;	
	
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 100, message = "Age should not be greater than 100")
	private byte userAge;			

}
