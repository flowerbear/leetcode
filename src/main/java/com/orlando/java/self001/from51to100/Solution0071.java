package com.orlando.java.self001.from51to100;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Simplify Path
 *
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
 * file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to
 * the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *   The path starts with a single slash '/'.
 *   Any two directories are separated by a single slash '/'.
 *   The path does not end with a trailing '/'.
 *   The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 *
 * Return the simplified canonical path.
 *
 */
public class Solution0071 {

  public String simplifyPath(String path) {
    LinkedList<String> st = new LinkedList<>();
    for (String s : path.split("/")) {
      if (s.equals("..")) st.poll();
      else if (!s.equals("") && !s.equals(".")) st.push(s);
    }

    StringBuilder sb = new StringBuilder();
    if (st.size() == 0) return "/";
    while (!st.isEmpty()) sb.append("/").append(st.pollLast());
    return sb.toString();
  }
}
