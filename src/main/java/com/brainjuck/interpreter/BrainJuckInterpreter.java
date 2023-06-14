/*
 * MIT License
 * Copyright (c) 2023 Manish Dait
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */

package com.brainjuck.interpreter;

import com.brainjuck.error.BrainJuckException;
import java.util.Scanner;
import java.util.Stack;

/**
 * The {@link BrainJuckInterpreter} class is an implementation for brainfuck interpreter.
 *
 */

public class BrainJuckInterpreter {
  private static Scanner scan = new Scanner(System.in);
  private static byte[] memory = new byte[30000];
  private static short[] loop_tracker;
  private static int location_pointer = 0;

  public BrainJuckInterpreter(String code) throws BrainJuckException {
    validateLoops(code);
    interpreter(code);
  }

  public static void interpreter(String code) {
    for (int instruction_pointer = 0; instruction_pointer < code.length(); instruction_pointer++) {
      switch (code.charAt(instruction_pointer)) {
        case '>':
          if (location_pointer >= memory.length - 1) {
            location_pointer = 0;
            break;
          }
          location_pointer++;
          break;
                
        case '<':
          if (location_pointer <= 0) {
            location_pointer = memory.length - 1;
            break;
          }
          location_pointer--;
          break;

        case '+':
          memory[location_pointer]++;
          break;

        case '-':
          memory[location_pointer]--;
          break;

        case '.':
          System.out.print((char) memory[location_pointer]);
          break;

        case ',':
          System.out.print("\n");
          memory[location_pointer] = (byte) scan.next().charAt(0);
          System.out.print("\n");
          break;

        case '[':
          if (memory[location_pointer] == 0) {
            instruction_pointer = loop_tracker[instruction_pointer];
            break;
          }
          break;

        case ']':
          if (memory[location_pointer] == 0) {
            break;
          }
          instruction_pointer = loop_tracker[instruction_pointer];
          break;

        default:
          break;
      }
    }
  }
  
  protected static void validateLoops(String code) throws BrainJuckException {
    Stack<Integer> stack = new Stack<Integer>();
    loop_tracker = new short[code.length()];
    int open = 0;
    int close = 0;

    for (int i = 0; i < code.length(); i++) {
      if (code.charAt(i) == '[') {
        open++;
        stack.push(i);
      }

      if (code.charAt(i) == ']') {
        int indx = stack.pop();
        loop_tracker[i] = (short) indx;
        loop_tracker[indx] = (short) i;
      }

      if (open < close) {
        break;
      }
    }

    if (!stack.isEmpty()) {
      throw new BrainJuckException(BrainJuckException.Exception.LoopMissMatch ,"Syntax error '[' or ']' opening or closing of loop is missing.");
    }
  }
     
}
