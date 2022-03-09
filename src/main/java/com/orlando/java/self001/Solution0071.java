package com.orlando.java.self001;

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
    Deque<String> stack = new LinkedList<>();
    for (String s : path.split("/")) {
      if (s.equals("..")) stack.poll();
      else if (!s.equals("") && !s.equals(".")) stack.push(s);
    }
    StringBuilder sb = new StringBuilder();
    if (stack.size() == 0) return "/";
    while (stack.size() != 0) sb.append("/").append(stack.pollLast());
    return sb.toString();
  }
}
