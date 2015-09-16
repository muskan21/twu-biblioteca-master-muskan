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

        Roles roles = new Roles(Role.GUEST, operations);
        ArrayList<String> operation = roles.canPerformOperations();

        assertEquals(operations, operation);
    }

    @Test
    public void shouldBeEqualWhenComparingARoleToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.CUSTOMER, operations);
        assertEquals(roles, roles);
    }

    @Test
    public void shouldBeEqualWhenComparingARoleToAnotherRoleWithSameRoles() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.CUSTOMER, operations);
        Roles roles1 = new Roles(Role.CUSTOMER, operations);
        assertEquals(roles, roles1);
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToNull() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.CUSTOMER, operations);
        assertNotEquals(roles, null);
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToNonRoleEntity() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles roles = new Roles(Role.CUSTOMER, operations);
        assertNotEquals(roles, "I am Not a Role");
    }

    @Test
    public void shouldNotBeEqualWhenComparingARoleToAnotherRoleWithDifferentRoles() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles role = new Roles(Role.CUSTOMER, operations);
        ArrayList<String> operations1 = new ArrayList<String>();
        operations1.add("1");
        operations1.add("2");
        operations1.add("3");
        operations1.add("4");
        operations1.add("L");
        operations1.add("Q");
        Roles role1 = new Roles(Role.GUEST, operations1);
        assertNotEquals(role, role1);
    }

    @Test
    public void shouldHaveSameHashCodeComparingARoleToItself() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles role = new Roles(Role.CUSTOMER, operations);
        assertEquals(role.hashCode(), role.hashCode());
    }

    @Test
    public void shouldHaveSameHashCodeComparingARoleToAnotherRoleWithSameRoles() {
        ArrayList<String> operations = new ArrayList<String>();
        operations.add("1");
        operations.add("2");
        operations.add("3");
        operations.add("L");
        operations.add("Q");
        Roles role = new Roles(Role.GUEST, operations);
        Roles role1 = new Roles(Role.GUEST, operations);
        assertEquals(role.hashCode(), role1.hashCode());
    }
}
