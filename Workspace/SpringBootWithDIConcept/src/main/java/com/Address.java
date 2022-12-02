package com;

import org.springframework.stereotype.Component;

@Component
public class Address {
private String city;
private String state;
@Override
public String toString() {
	return "Address [city=" + city + ", state=" + state + "]";
}

}
