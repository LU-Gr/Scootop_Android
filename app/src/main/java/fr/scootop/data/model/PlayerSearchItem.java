package fr.scootop.data.model;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PlayerSearchItem implements Parcelable
{
	@Expose
	public String name;
	@Expose
	@Nullable
	public String image;
	/**
	 * Nationality country name
	 */
	@Expose
	@Nullable
	public String nationality;
	/**
	 * Nationality country iso code (like FR for France)
	 */
	@Expose
	@Nullable
	@SerializedName("nationality_iso_code")
	public String nationalityIsoCode;
	/**
	 * Origin country name
	 */
	@Expose
	@Nullable
	public String origin;
	/**
	 * Origin country iso code (like FR for France)
	 */
	@Expose
	@Nullable
	@SerializedName("origin_iso_code")
	public String originIsoCode;
	@Expose
	@SerializedName("player_id")
	public Integer playerId;
	@Expose
	public String footed;
	@Expose
	@SerializedName("team_id")
	@Nullable
	public Integer teamId;
	@Expose
	@SerializedName("team_name")
	@Nullable
	public String teamName;
	@Expose
	@SerializedName("club_id")
	@Nullable
	public Integer clubId;
	@Expose
	@SerializedName("club_name")
	@Nullable
	public String clubName;
	@Expose
	@SerializedName("club_image")
	@Nullable
	public String clubImage;
	@Expose
	@SerializedName("position_id")
	@Nullable
	public Integer positionId;
	@Expose
	@SerializedName("position_name")
	@Nullable
	public String positionName;
	@Expose
	@Nullable
	public String department;

	public PlayerSearchItem()
	{
	}
	public PlayerSearchItem(Parcel in)
	{
		name = in.readString();
		image = in.readString();
		nationality = in.readString();
		nationalityIsoCode = in.readString();
		origin = in.readString();
		originIsoCode = in.readString();
		playerId = in.readInt();
		footed = in.readString();
		teamId = in.readInt();
		teamName = in.readString();
		clubId = in.readInt();
		clubName = in.readString();
		clubImage = in.readString();
		positionId = in.readInt();
		positionName = in.readString();
		department = in.readString();
	}
	@Override
	public int describeContents()
	{
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags)
	{
		dest.writeString(name);
		dest.writeString(image);
		dest.writeString(nationality);
		dest.writeString(nationalityIsoCode);
		dest.writeString(origin);
		dest.writeString(originIsoCode);
		dest.writeInt(playerId);
		dest.writeString(footed);
		dest.writeInt(teamId != null ? teamId : -1);
		dest.writeString(teamName);
		dest.writeInt(clubId != null ? clubId : -1);
		dest.writeString(clubName);
		dest.writeString(clubImage);
		dest.writeInt(positionId != null ? positionId : -1);
		dest.writeString(positionName);
		dest.writeString(department);
	}
	public static final Creator<PlayerSearchItem> CREATOR = new Creator<PlayerSearchItem>()
	{
		@Override
		public PlayerSearchItem createFromParcel(Parcel in)
		{
			return new PlayerSearchItem(in);
		}
		@Override
		public PlayerSearchItem[] newArray(int size)
		{
			return new PlayerSearchItem[size];
		}
	};
}
