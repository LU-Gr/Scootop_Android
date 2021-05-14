package fr.scootop.app.register;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mukesh.countrypicker.CountryPicker;
import com.mukesh.countrypicker.CountryPickerListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.scootop.R;

public class LegacyRegisterPlayerActivity extends AppCompatActivity
{
	@BindView(R.id.inscription_nationality_edittext)
	EditText mNationalityEditText;

	@BindView(R.id.inscription_origine_edittext)
	EditText mOriginEditText;

	@BindView(R.id.inscription_pays_edittext)
	EditText mCountryEditText;

	@BindView(R.id.inscription_foot_edittext)
	EditText mFootEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_playeur);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.inscription_nationality_edittext)
	public void selectNationalityCountry()
	{
		final CountryPicker picker = CountryPicker.newInstance(getString(R.string.form_inscription_nationality));
		picker.setListener(new CountryPickerListener() {
			@Override
			public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
				mNationalityEditText.setText(name);
				picker.dismiss();
			}
		});
		picker.show(getSupportFragmentManager(), "NAT_COUNTRY_PICKER");
	}

	@OnClick(R.id.inscription_origine_edittext)
	public void selectOriginCountry()
	{
		final CountryPicker picker = CountryPicker.newInstance(getString(R.string.form_inscription_origine));
		picker.setListener(new CountryPickerListener() {
			@Override
			public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
				mOriginEditText.setText(name);
				picker.dismiss();
			}
		});
		picker.show(getSupportFragmentManager(), "ORI_COUNTRY_PICKER");
	}

	@OnClick(R.id.inscription_pays_edittext)
	public void selectClubCountry()
	{
		final CountryPicker picker = CountryPicker.newInstance(getString(R.string.form_inscription_pays));
		picker.setListener(new CountryPickerListener() {
			@Override
			public void onSelectCountry(String name, String code, String dialCode, int flagDrawableResID) {
				mCountryEditText.setText(name);
				picker.dismiss();
			}
		});
		picker.show(getSupportFragmentManager(), "CLB_COUNTRY_PICKER");
	}

	@OnClick(R.id.inscription_foot_edittext)
	public void selectFoot()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.form_foot)
			.setItems(R.array.foot, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					String[] footChoices = getResources().getStringArray(R.array.foot);
					mFootEditText.setText(footChoices[which]);
					dialog.dismiss();
				}
			});

		builder.create().show();
	}
}
