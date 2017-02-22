package edu.andrews.cptr252.seungsub.quoteoftheday_final;

/**
 * Created by Markus Oh on 2/21/2017.
 */

public class Quote {
    /** Reference to quote text */
    private int mQuote;

    /** Reference to quote's author */
    private int mAuthor;

    /**
     * Create a new quote
     * @param quote     Resource id for quote text
     * @param author    Resource id for quote author
     */
    public Quote(int quote, int author) {
        mQuote = quote;
        mAuthor = author;
    }

    //  getters and setters
    public int getQuote() {
        return mQuote;
    }
    public void setQuote(int quote) {
        mQuote = quote;
    }
    public int getAuthor() {
        return mAuthor;
    }
    public void setAuthor(int author) {
        mAuthor = author;
    }
}
