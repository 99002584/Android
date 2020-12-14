package com.example.notificationadvertiser;

//public class customAdapter {
//}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import static com.example.notificationadvertiser.ItemClass.card;
import static com.example.notificationadvertiser.ItemClass.card1;
import java.util.ArrayList;
import java.util.List;

public class customAdapter extends RecyclerView.Adapter {
    private List<ItemClass> itemClassList;

    public customAdapter(List<ItemClass> itemClassList) {
        this.itemClassList = itemClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case card:
                View layoutOne
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card, parent,
                                false);
                return new cardViewHolder(layoutOne);
            case card1:
                View layoutTwo
                        = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card1, parent,
                                false);
                return new card1ViewHolder(layoutTwo);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        switch (itemClassList.get(position).getViewType()) {
            case card:
                ArrayList<String> aname = itemClassList.get(position).getaName();
                ArrayList<String> aCampaign = itemClassList.get(position).getaCampaign();
                ArrayList<String> aInfluencer = itemClassList.get(position).getaInfluencer();
                ArrayList<String> aPrice = itemClassList.get(position).getaPrice();
                ArrayList<String> aTime = itemClassList.get(position).getaTime();
                break;
            case card1:
                ArrayList<String> bname = itemClassList.get(position).getbName();
                ArrayList<String> bCampaign = itemClassList.get(position).getbCampaign();
                ArrayList<String> bInfluencer = itemClassList.get(position).getbInfluencer();
                break;
        }
    }


    public int getItemViewType(int position) {
        switch (itemClassList.get(position).getViewType()) {
            case 0:
                return card;
            case 1:
                return card1;
            default:
                return -1;
        }
    }

    @Override
  public int getItemCount() {
        return itemClassList.size();
    }

    class cardViewHolder extends ViewHolder {
        TextView name;
        TextView influencer;
        TextView campaign;
        TextView price;
        TextView time;
        Button accept;
        Button reject;
        CardView card;

        public cardViewHolder(@NonNull View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.NotificationName);
            influencer = (TextView) v.findViewById(R.id.Influencer);
            campaign = (TextView) v.findViewById(R.id.CampaignName);
            price = (TextView) v.findViewById(R.id.aPrice);
            time = (TextView) v.findViewById(R.id.aTime);
            accept = (Button) v.findViewById(R.id.aAccept);
            reject = (Button) v.findViewById(R.id.aReject);
            card = (CardView) v.findViewById(R.id.card);
        }

        private void setViews(ArrayList<String> cName, ArrayList<String> cInfluencer, ArrayList<String> cCampaign, ArrayList<String> cPrice, ArrayList<String> cTime) {
            name.setText((CharSequence) cName);
            influencer.setText((CharSequence) cInfluencer);
            campaign.setText((CharSequence) cCampaign);
            price.setText((CharSequence) cPrice);
            time.setText((CharSequence) cTime);

        }
    }

    class card1ViewHolder extends ViewHolder {
        TextView namE;
        TextView influenceR;
        TextView campaigN;
        CardView card1;

        public card1ViewHolder(@NonNull View v) {
            super(v);
            namE = (TextView) v.findViewById(R.id.NotificationName);
            influenceR = (TextView) v.findViewById(R.id.Influencer);
            campaigN = (TextView) v.findViewById(R.id.CampaignName);
            card1 = (CardView) v.findViewById(R.id.card);
        }

        private void setViews(ArrayList<String> dName, ArrayList<String> dInfluencer, ArrayList<String> dCampaign) {
            namE.setText((CharSequence) dName);
            influenceR.setText((CharSequence) dInfluencer);
            campaigN.setText((CharSequence) dCampaign);
        }
    }


}

