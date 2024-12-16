package edu.grinnell.csc207.util;

import static edu.grinnell.csc207.util.MatrixAssertions.assertMatrixEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Test for the Matrix class referenced SamR TestMatrix.java
 *
 * @author Jenifer Silva
 */
public class StudentTests {

    @Test
    void testStudentAssorted() {
        Matrix<String> strings = new MatrixV0(2, 2, " ");
        assertMatrixEquals(new String[][] {{" ", " ",}, {" ", " "}}, strings, "original matrix");

        strings.fillRegion(0, 0, 2, 2, "wow");
        assertMatrixEquals(new String[][] {{"wow", "wow"}, 
                                           {"wow", "wow"}}, strings,
                " wow filling the whole matrix");

        strings.insertRow(2);
        assertMatrixEquals(
                new String[][] {{"wow", "wow"}, 
                                {"wow", "wow"}, 
                                {" ", " "}},
                strings, "after inserting row 2");

        strings.insertCol(2);
        assertMatrixEquals(
                new String[][] {{"wow", "wow", " "},
                                {"wow", "wow", " "},
                                {" ", " ", " "}},
                strings, ": After inserting the last column");
        strings.deleteCol(0);
        assertMatrixEquals(new String[][]  {{"wow", " "},
                                            {"wow", " "},
                                            {" ", " "}}, strings, " After deleting column 0");

                strings.deleteRow(1);
        assertMatrixEquals(new String[][]  {{"wow", " "},
                                            {" ", " "}}, strings, " After deleting column 0");
    } // testAssorted()



    /**
     * Test for exceptions in set.
     */
    @Test
    public void testSetException() {
        Matrix<String> matrix = new MatrixV0(10, 10);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix.set(11, 1, "aaaaaa");
        }, " set with overflow row");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix.set(1, 11, "eeeeee");
        }, "set with overflow col");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix.set(20, 20, "iiiiiii");
        }, "set with overflow row and col");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            matrix.set(-1, -2, "ooooooo");
        }, "set with negative row and column");
    } // testSetException


    /*
     * Some assorted tests.
     */
    @Test
    void testAssortedMine() {
        Matrix<String> strings = new MatrixV0(15, 8, " ");
        assertMatrixEquals(new String[][] {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},},
                strings, "M: original matrix");

        strings.fillLine(1, 2, 2, 4, 7, 12, "a");
        assertMatrixEquals(new String[][] {
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", "a", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", "a", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "a", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},},
                strings, "filling the matrix");
    }


    /**
   * Test for exceptions in get.
   */
  @Test
  public void testGetException() {
    Matrix<String> matrix = new MatrixV0(100, 100);
    assertThrows(IndexOutOfBoundsException.class,
        () -> {matrix.get(-100, 100);},
        "get with negative row");
    assertThrows(IndexOutOfBoundsException.class,
        () -> {matrix.get(101, 1);},
        "get with much too big row");
    assertThrows(IndexOutOfBoundsException.class,
        () -> {matrix.get(100, 101);},
        "get with slightly too big col");
    assertThrows(IndexOutOfBoundsException.class,
        () -> {matrix.get(-1, -1);},
        "negative row and col");
  }


}
