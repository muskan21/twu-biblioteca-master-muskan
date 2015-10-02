package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class InterpreterTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitIfExitOptionIsChosen() {
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("Q");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        BookLibrary bookLibrary = new BookLibrary(new ArrayList<Book>());
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin, parser);

        exit.expectSystemExit();

        interpreter.interpret("Q");
    }

    @Test
    public void shouldInvokeDisplayMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        Parser parser = mock(Parser.class);
        Interpreter interpreter = new Interpreter(bookLibrary, new MovieLibrary(new ArrayList<Movie>()), new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin, parser);

        when(parser.parse("1")).thenReturn(new ListBooksOption(bookLibrary));
        interpreter.interpret("1");

        verify(parser, times(1)).parse("1");
    }

    @Test
    public void shouldInvokeMovieDisplayMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("2");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        BookLibrary bookLibrary = new BookLibrary(new ArrayList<Book>());
        Parser parser = mock(Parser.class);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin, parser);

        when(parser.parse("2")).thenReturn(new ListMoviesOption(movieLibrary));
        interpreter.interpret("2");

        verify(parser, times(1)).parse("2");
    }

    @Test
    public void shouldInvokeCheckOutMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("4");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("4");

        verify(bookLibrary, times(1)).checkOutBook(anyString(), any(User.class));
    }

    @Test
    public void shouldInvokeMovieCheckOutMethodCallForTheSelectedOption() {
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("3");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        BookLibrary bookLibrary = new BookLibrary(new ArrayList<Book>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("3");

        verify(movieLibrary, times(1)).checkOutMovie("gone girl");
    }

    @Test
    public void shouldInvokeReturnMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("5");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("5");

        verify(bookLibrary, times(1)).returnBook(anyString(), any(User.class));
    }

    @Test
    public void shouldPrintTheAppropriateMessageWhenInvalidOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        OutputConsole out = new OutputConsole(new PrintStream(output));
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, out, user, bibliotecaAdmin, parser);

        interpreter.interpret("Muskan");

        assertEquals("Select A Valid Option!!\n", output.toString());
    }

    @Test
    public void shouldNotPrintTheCurrentUsersMenuWhenLogoutOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        OutputConsole out = new OutputConsole(new PrintStream(output));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        User user = new User("muskan", "password", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, out, user, bibliotecaAdmin, parser);

        ArrayList<String> testUser = interpreter.interpret("0");

        assertNotEquals(testUser.toString(), user.canPerformOperations().toString());
    }

    @Test
    public void shouldPrintTheGuestUsersMenuWhenLogoutOptionIsSelected() {
        ArrayList<Book> books = new ArrayList<Book>();
        BookLibrary bookLibrary = new BookLibrary(books);
        InputConsole inputConsole = new InputConsole(new Scanner(System.in));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        OutputConsole out = new OutputConsole(new PrintStream(output));
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        User user = new User("muskan", "password", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, out, user, bibliotecaAdmin, parser);

        ArrayList<String> testUser = interpreter.interpret("0");
        User user1 = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);

        assertEquals(testUser.toString(), user1.canPerformOperations().toString());
    }

    @Test
    public void shouldLoginAUserWhenAppropriateOptionIsSelectedAndCredentialsMatch() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("L");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("123-5678", "password1");

        ArrayList<String> testString = interpreter.interpret("L");
        Roles role = rolesFactory.assignOperations(Role.CUSTOMER);

        assertEquals(testString, role.canPerformOperations());
    }

    @Test
    public void shouldNotLoginAUserWhenAppropriateOptionIsSelectedAndCredentialsDoNotMatch() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("123-5680", "password8");

        ArrayList<String> testString = interpreter.interpret("L");
        operation.add("2");
        operation.add("3");
        operation.add("L");
        operation.add("Q");

        assertEquals(testString, operation);
    }

    @Test
    public void shouldReturnGuestUsersOperationWhenLogoutOptionIsSelected() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        User user = new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0);
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        ArrayList<String> testUserString = interpreter.interpret("0");

        Roles role = rolesFactory.assignOperations(Role.GUEST);
        assertEquals(role.canPerformOperations().toString(), testUserString.toString());
    }

    @Test
    public void shouldNotAcceptNonGuestUserOperationAsInputIfGuestUserIsLoggedIn() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        MovieLibrary movieLibrary = mock(MovieLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputConsole outputConsole = new OutputConsole(new PrintStream(byteArrayOutputStream));
        RolesFactory rolesFactory = new RolesFactory();
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole1 = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole1);
        User user = new User("123-1234", "password", rolesFactory.assignOperations(Role.GUEST), "", "", 0);
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        ArrayList<String> testUserString = interpreter.interpret("0");

        assertEquals(byteArrayOutputStream.toString(), "Select A Valid Option!!\n");
    }

    @Test
    public void shouldRunEvenIfInputIsInLowerCase() {
        ArrayList<String> operation = new ArrayList<String>();
        operation.add("1");
        operation.add("Q");
        User user = new User("muskan", "password", new Roles(Role.GUEST, operation), "", "", 0);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        BookLibrary bookLibrary = new BookLibrary(new ArrayList<Book>());
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, new InputConsole(new Scanner(System.in)), new OutputConsole(new PrintStream(System.out)), user, bibliotecaAdmin, parser);

        exit.expectSystemExit();

        interpreter.interpret("q");
    }

    @Test
    public void shouldInvokeLibraryStatusMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        User user = new User("muskan", "password", rolesFactory.assignOperations(Role.LIBRARIAN), "", "", 0);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        when(inputConsole.getInput()).thenReturn("gone girl");

        interpreter.interpret("7");

        verify(bookLibrary, times(1)).bookLibraryStatus();
    }

    @Test
    public void shouldInvokeLUserDetailMethodCallForTheSelectedOption() {
        BookLibrary bookLibrary = mock(BookLibrary.class);
        InputConsole inputConsole = mock(InputConsole.class);
        ArrayList<User> users = new ArrayList<User>();
        RolesFactory rolesFactory = new RolesFactory();
        users.add(new User("123-5678", "password1", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        users.add(new User("123-5679", "password2", rolesFactory.assignOperations(Role.CUSTOMER), "", "", 0));
        User user = mock(User.class);
        OutputConsole outputConsole = mock(OutputConsole.class);
        BibliotecaAdmin bibliotecaAdmin = new BibliotecaAdmin(users, rolesFactory, outputConsole);
        MovieLibrary movieLibrary = new MovieLibrary(new ArrayList<Movie>());
        Parser parser = new Parser(bookLibrary, movieLibrary);
        Interpreter interpreter = new Interpreter(bookLibrary, movieLibrary, inputConsole, outputConsole, user, bibliotecaAdmin, parser);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("6");
        when(user.canPerformOperations()).thenReturn(arrayList);
        interpreter.interpret("6");

        verify(user, times(1)).formattedUserDetails();
    }
}
