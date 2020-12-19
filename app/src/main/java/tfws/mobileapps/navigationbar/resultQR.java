package tfws.mobileapps.navigationbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class resultQR extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Result");
        return inflater.inflate(R.layout.resultqr,container,false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ImageButton fav_button,share_button,web_search,copy_to_clipboard;
        fav_button = (ImageButton) view.findViewById(R.id.favorite_ib);
        web_search = (ImageButton) view.findViewById(R.id.web_search_ib);
        share_button = (ImageButton) view.findViewById(R.id.share_ib);
        copy_to_clipboard = (ImageButton) view.findViewById(R.id.clipboard_ib);
        final String value = getArguments().getString("Key");
        final TextView result = (TextView)view.findViewById(R.id.result);
        result.setText(value);
        fav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fav_button.setImageResource(R.drawable.ic_star_clicked);
                Toast.makeText(getActivity(), "Added to favourites", Toast.LENGTH_SHORT).show();
            }
        });

        copy_to_clipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Text",result.getText().toString());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = result.getText().toString();
                //String shareSubject = value;
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));

            }
        });



       /* ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clip =ClipData.newPlainText("EditText",MainActivity.t.getText().toString());
        clipboard.setPrimaryClip(clip);


        */

    }



}
