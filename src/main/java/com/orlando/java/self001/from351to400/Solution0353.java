package com.orlando.java.self001.from351to400;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Design Snake Game
 *
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you
 * are not familiar with the game.
 *
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 *
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the
 * game's score both increase by 1.
 *
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food
 * was eaten by the snake.
 *
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 *
 */
public class Solution0353 {

  public class SnakeGame {
    // Use a set to hold all occupied points for the snake body, this is for easy access for the case of eating its
    // own body
    private Set<Integer> set;
    // use a queue to hold all occupied points for the snake body as well, this is for easy access to update the tail
    private Deque<Integer> body;

    int[][] food;
    int score;
    int foodIndex;
    int width;
    int height;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
      this.set = new HashSet<>();
      set.add(0);
      this.body = new LinkedList<>();
      body.offerLast(0);
      this.food = food;
      this.width = width;
      this.height = height;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
      if (score == -1) return -1;
      int rowHead = body.peekFirst() / width;
      int colHead = body.peekFirst() % width;
      switch (direction) {
        case "U":
          rowHead--;
          break;
        case "D":
          rowHead++;
          break;
        case "L":
          colHead--;
          break;
        default:
          colHead++;
      }
      int newHead = rowHead * width + colHead;
      set.remove(body.peekLast());
      if (set.contains(newHead) || rowHead < 0 || colHead < 0 || rowHead >= height || colHead >= width) {
        return score = -1;
      }

      //add head for the following two normal cases:
      set.add(newHead);
      body.offerFirst(newHead);

      // Normal eat case: keep tail, add head
      if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
        set.add(body.peekLast());
        foodIndex++;
        return ++score;
      }

      // Normal move case without eating: move head and remove tail;
      body.pollLast();
      return score;
    }
  }
}

