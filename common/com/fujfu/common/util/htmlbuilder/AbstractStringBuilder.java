package com.fujfu.common.util.htmlbuilder;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class AbstractStringBuilder {
	 private Writer writer;

	  /**
	   * Default constructor using a StringWriter,
	   * which is really just a StringBuffer.
	   */
	  public AbstractStringBuilder() {
	    this.writer = new StringWriter();
	  }

	  /**
	   * A builder with the specified Writer.
	   *
	   * @param writer The Writer to use.
	   */
	  public AbstractStringBuilder(Writer writer) {
	    this.writer = writer;
	  }

	  /**
	   * Flush the writer.
	   */
	  public void flushBuilder() {
	    try {
	      writer.flush();
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	  }

	  /**
	   * Close the writer.
	   */
	  public void closeBuilder() {
	    try {
	      writer.close();
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	  }

	  /**
	   * Write out the content to the internal writer.
	   */
	  protected AbstractStringBuilder write(String text) {
	    try {
	      writer.write(text);
	    } catch(IOException e) {
	      e.printStackTrace();
	    }
	    return this;
	  }

	  /**
	   * The length of the internal Writer.
	   */
	  public int length() {
	    return writer.toString().length();
	  }

	  /**
	   * The Object to append. Will call the Object's toString() method.
	   */
	  public AbstractStringBuilder append(Object text) {
	    if(text != null) {
	      write(text.toString());
	    }

	    return this;
	  }

	  /**
	   * The String to append.
	   */
	  public AbstractStringBuilder append(String text) {
	    write(text);

	    return this;
	  }

	  @Override
	public String toString() {
	    return writer.toString();
	  }
}
