package edu.andrews.cptr252.seungsub.quoteoftheday_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class QuoteActivity extends AppCompatActivity {
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.seungsub.quoteoftheday_final.author_fact";
    private static final String KEY_QUOTE_INDEX = "quoteIndex";

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /** Quotes used in app */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2)
    };

    /** Index of current quote in list */
    private int mCurrentIndex = 0;

    /** Save the currentIndex before QuoteActivity is destroyed */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        //Store the index of the current quote in the Bundle
        //Use our key to access the value later
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }

    /** Display the quote at the current index */
    private void updateQuote(){
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    /** Launch activity to display author fact */
    private void displayAuthorFact(){
        //Create intent with name of class for second activity
        //This intent will be sent to the Activity Manager in the OS
        //which will launch the activity.
        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);
        //Add extra containing resource id for fact
        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
        //Send the intent to the Activity Manager
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        //Re-display the same quote we were on when activity was destroyed.
        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        //Display the text for the quote
        mQuoteTextView = (TextView) findViewById(R.id.quoteTextView);
        int quote = mQuoteList[mCurrentIndex].getQuote();
        mQuoteTextView.setText(quote);
        mQuoteTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayAuthorFact();
            }
        });

        //Display the author of the quote
        mAuthorTextView = (TextView) findViewById(R.id.authorTextView);
        int author = mQuoteList[mCurrentIndex].getAuthor();
        mAuthorTextView.setText(author);
        mAuthorTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayAuthorFact();
            }
        });

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
