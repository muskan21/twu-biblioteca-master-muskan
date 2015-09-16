package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RolesTest {

    @Test
    public void foo() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");

        Roles roles = new Roles(Role.GUEST);
        ArrayList<String> operation = roles.canPerformOperations();

        assertEquals(operations, operation);
    }

    @Test
    public void shouldBeEqualWhenComparingARoleToItself() {
        Roles roles = new Roles(Role.CUSTOMER);
        assertEquals(roles, roles);
    }

    @Test
    public void shouldBeEqualWhenComparingARoleToAnotherRoleWithSameRoles() {
        Roles roles = new Roles(Role.CUSTOMER);
        Roles roles1 = new Roles(Role.CUSTOMER);
        assertEquals(roles, roles1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToNull() {
        Roles roles = new Roles(Role.CUSTOMER);
        assertNotEquals(roles, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToNonRoleEntity() {
        Roles roles = new Roles(Role.CUSTOMER);
        assertNotEquals(roles, "I am Not a Book");
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToAnotherRoleWithDifferentRoles() {
        Roles role = new Roles(Role.CUSTOMER);
        Roles role1 = new Roles(Role.GUEST);
        assertNotEquals(role, role1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingARoleToItself() {
        Roles role = new Roles(Role.CUSTOMER);
        assertEquals(role.hashCode(), role.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingARoleToAnotherRoleWithSameRoles() {
        Roles role = new Roles(Role.GUEST);
        Roles role1 = new Roles(Role.GUEST);
        assertEquals(role.hashCode(), role1.hashCode());
    }
}
