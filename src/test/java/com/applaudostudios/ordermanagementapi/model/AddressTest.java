package com.applaudostudios.ordermanagementapi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Address Test")
class AddressTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Address}
     *   <li>{@link Address#setAddress1(String)}
     *   <li>{@link Address#setAddress2(String)}
     *   <li>{@link Address#setCity(City)}
     *   <li>{@link Address#setCountry(Country)}
     *   <li>{@link Address#setId(long)}
     *   <li>{@link Address#setState(State)}
     *   <li>{@link Address#setUser(User)}
     *   <li>{@link Address#getAddress1()}
     *   <li>{@link Address#getAddress2()}
     *   <li>{@link Address#getCity()}
     *   <li>{@link Address#getCountry()}
     *   <li>{@link Address#getId()}
     *   <li>{@link Address#getState()}
     *   <li>{@link Address#getUser()}
     * </ul>
     */
    @Test
    @DisplayName("Address Setters and Getters")
    void testConstructor() {
        Address actualAddress = new Address();
        actualAddress.setAddress1("42 Main St");
        actualAddress.setAddress2("42 Main St");

        City city = new City();
        actualAddress.setCity(city);

        Country country = new Country();
        actualAddress.setCountry(country);
        actualAddress.setId(123L);

        State state = new State();
        actualAddress.setState(state);

        User user = new User();
        user.setAddressList(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPaymentMethods(new ArrayList<>());
        user.setPhoneNumber("4105551212");

        actualAddress.setUser(user);
        assertEquals("42 Main St", actualAddress.getAddress1());
        assertEquals("42 Main St", actualAddress.getAddress2());
        assertSame(city, actualAddress.getCity());
        assertSame(country, actualAddress.getCountry());
        assertEquals(123L, actualAddress.getId());
        assertSame(state, actualAddress.getState());
        assertSame(user, actualAddress.getUser());
    }
}

