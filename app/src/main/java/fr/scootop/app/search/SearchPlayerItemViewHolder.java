package fr.scootop.app.search;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;
import fr.scootop.app.common.ImageHelper;
import fr.scootop.data.model.user.domain.PlayerSearchResult;

public class SearchPlayerItemViewHolder
{
    @BindView(R.id.row_search_avatar)
    CircularImageView mAvatarView;

    @BindView(R.id.row_search_name_label)
    TextView mNameTextView;

    @BindView(R.id.row_search_country_image)
    ImageView mCountryImageView;

    public SearchPlayerItemViewHolder(View view)
    {
        ButterKnife.bind(this, view);
    }

    public void setPlayerItem(PlayerSearchResult item)
    {
        mNameTextView.setText(item.getFirstName() + " " + item.getLastName());

        if (!TextUtils.isEmpty(item.getPhotoUrl())) {
            /** charge l'avatar en ligne */
            Glide.with(mAvatarView.getContext())
                 .load(ImageHelper.INSTANCE.getUserAvatarUrl(item.getPhotoUrl()))
                 .fitCenter()
                 .placeholder(R.mipmap.ic_default_avatar)
                 .into(mAvatarView);
        } else {
            /** affiche l'avatar par défaut */
            mAvatarView.setImageResource(R.mipmap.ic_default_avatar);
        }

        /** reset l'image du pays */
        mCountryImageView.setImageDrawable(null);

        //if (!TextUtils.isEmpty(item.nationalityIsoCode)) {
        //    Country country = Country.getCountryByISO(item.nationalityIsoCode);
        //    if (null != country) {
        //        /** affiche l'image du pays seulement si le pays est défini et trouvé **/
        //        mCountryImageView.setImageResource(country.getFlag());
        //    }
        //}
    }
}
