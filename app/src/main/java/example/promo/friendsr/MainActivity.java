package example.promo.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connects listener to grid view
        GridView gridView = findViewById(R.id.gridView1);
        gridView.setOnItemClickListener(new GridItemClickListener());

        // creates Friend objects and stores them in array list
        friendsCreate();

        // connects adapter to grid view and list
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        gridView.setAdapter(adapter);
    }

    // passes information to second activity when user clicks on item
    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }

    /**
     * This function creates new Friend objects, with each object containing a name, bio
     * (i.e. quote), corresponding episode and ID of drawable, storing them in array list.
     */
    public void friendsCreate() {

        // creates chandler...
        int chandlerId = getResources().getIdentifier("chandler", "drawable", getPackageName());
        Friend chandler = new Friend("Chandler Bing",
                "\"I'm not so good with the advice. Can I interest you in a sarcastic comment?\"",
                "Season 8: The One With The Tea Leaves", chandlerId);
        friends.add(chandler);

        // creates joey...
        int joeyId = getResources().getIdentifier("joey", "drawable", getPackageName());
        Friend joey = new Friend("Joey Tribbiani",
                "\"Why do you have to break up with her? Be a man. Just stop calling.\"",
                "Season 1: The One With The East German Laundry Detergent", joeyId);
        friends.add(joey);

        // creates ross...
        int rossId = getResources().getIdentifier("ross", "drawable", getPackageName());
        Friend ross = new Friend("Ross Geller",
                "\"We were on a break!\"",
                "Season 3: The One Without The Ski Trip", rossId);
        friends.add(ross);

        // creates monica...
        int monicaId = getResources().getIdentifier("monica", "drawable", getPackageName());
        Friend monica = new Friend("Monica Geller",
                "\"Welcome to the real world. It sucks. You’re gonna love it!\"",
                "Season 1: The One Where Monica Gets A Roommate", monicaId);
        friends.add(monica);

        // creates rachel...
        int rachelId = getResources().getIdentifier("rachel", "drawable", getPackageName());
        Friend rachel = new Friend("Rachel Green",
                "\"Oh, are you setting Ross up with someone? Does she have a wedding dress?\"",
                "Season 6: The One With Ross's teeth", rachelId);
        friends.add(rachel);

        // creates phoebe...
        int phoebeId = getResources().getIdentifier("phoebe", "drawable", getPackageName());
        Friend phoebe = new Friend("Phoebe Buffay",
                "\"Oh, you liked that? You should hear my phone number.\"",
                "Season 7: The One With Rachel's Assistant", phoebeId);
        friends.add(phoebe);

        // creates gunther...
        int guntherId = getResources().getIdentifier("gunther", "drawable", getPackageName());
        Friend gunther = new Friend("Gunther",
                "\"Hey buddy, this is a family place, put the mouse back in the house.\"",
                "Season 3: The One Where Monica And Richard Are Just Friends", guntherId);
        friends.add(gunther);

        // creates carol...
        int carolId = getResources().getIdentifier("carol", "drawable", getPackageName());
        Friend carol = new Friend("Carol Willick",
                "\"Please let there be a song!\"",
                "Season 3: The One With The Metaphorical Tunnel", carolId);
        friends.add(carol);

        // creates susan...
        int susanId = getResources().getIdentifier("susan", "drawable", getPackageName());
        Friend susan = new Friend("Susan Bunch",
                "\"Well, you know, you have to take a course. Otherwise they don't let you do it\"",
                "Season 1: The One Where The Underdog Gets Away", susanId);
        friends.add(susan);

        // creates judy...
        int judyId = getResources().getIdentifier("judy", "drawable", getPackageName());
        Friend judy = new Friend("Judy Geller",
                "\"This is worse than when he married the lesbian.\"",
                "Season 5: The One After Ross Says Rachel", judyId);
        friends.add(judy);

        // creates jack...
        int jackId = getResources().getIdentifier("jack", "drawable", getPackageName());
        Friend jack = new Friend("Jack Geller",
                "\"I'm not gonna tell you what they spent on that wedding. But $40,000 is a lot of money.\"",
                "Season 2: The One With The Sonogram At The End", jackId);
        friends.add(jack);

        // creates david...
        int davidId = getResources().getIdentifier("david", "drawable", getPackageName());
        Friend david = new Friend("David",
                "\"I’m here to explain to the people who " +
                        "gave us our grant, why it’s a positive thing that we spent all their money " +
                        "and accomplished uhm... nothing.\"",
                "Season 9: The One With The Male Nanny", davidId);
        friends.add(david);

        // creates frank
        int frankId = getResources().getIdentifier("frank", "drawable", getPackageName());
        Friend frank = new Friend("Frank Buffay",
                "\"Hey, y'know, Alice is gonna be here so soon, " +
                        "you couldn't just like do me a favor and like, like hold them in?\"",
                "Season 5: The One Hundredth", frankId);
        friends.add(frank);

        // creates mr heckles
        int hecklesId = getResources().getIdentifier("heckles", "drawable", getPackageName());
        Friend heckles = new Friend("Mr. Heckles",
                "\"I can hear you through the ceiling. My cats can't sleep.\"",
                "Season 1: The One With Two Parts, Part 1", hecklesId);
        friends.add(heckles);

        // creates janice
        int janiceId = getResources().getIdentifier("janice", "drawable", getPackageName());
        Friend janice = new Friend("Janice",
                "\"Oh My God!\"",
                "Season 1: The One With The Candy Hearts", janiceId);
        friends.add(janice);

        // creates mike
        int mikeId = getResources().getIdentifier("mike", "drawable", getPackageName());
        Friend mike = new Friend("Mike Hannigan",
                "\"Do you know what a bananahammock is?\"",
                "Season 10: The One With Princess Consuela", mikeId);
        friends.add(mike);
    }
}
