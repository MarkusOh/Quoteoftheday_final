package edu.andrews.cptr252.seungsub.quoteoftheday_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuoteActivity extends AppCompatActivity {
    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /** Quotes used in app */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0),
            new Quote(R.string.quote_text_1, R.string.quote_author_1),
            new Quote(R.string.quote_text_2, R.string.quote_author_2)
    };

    /** Index of current quote in list */
    private int mCurrentIndex = 0;

    /** Display the quote at the current index */
    private void updateQuote(){
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        //Display the text for the quote
        mQuoteTextView = (TextView) findViewById(R.id.quoteTextView);
        int quote = mQuoteList[mCurrentIndex].getQuote();
        mQuoteTextView.setText(quote);

        //Display the author of the quote
        mAuthorTextView = (TextView) findViewById(R.id.authorTextView);
        int author = mQuoteList[mCurrentIndex].getAuthor();
        mAuthorTextView.setText(author);

        //Set up listener to handle next button presses
        mNextButton = (Button) findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //move to next quote in the list
                //if index reaches end of array
                //reset index to zero (first quote)
                mCurrentIndex++;
                if(mCurrentIndex >= mQuoteList.length){
                    mCurrentIndex = 0;
                }
                updateQuote();
            }
        });

    }
}
