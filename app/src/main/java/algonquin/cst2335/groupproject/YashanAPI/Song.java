
package algonquin.cst2335.groupproject.YashanAPI;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Song implements Parcelable  {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int songId;
    private String title;
    private String artist;
    private int duration;
    private String albumName;
    private String albumCoverUrl;

    public Song() {
        // Default constructor
    }

    public Song(int songId, String title, String artist, int duration, String albumName, String albumCoverUrl) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.albumName = albumName;
        this.albumCoverUrl = albumCoverUrl;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumCoverUrl() {
        return albumCoverUrl;
    }

    public void setAlbumCoverUrl(String albumCoverUrl) {
        this.albumCoverUrl = albumCoverUrl;
    }
    protected Song(Parcel in) {
        songId = in.readInt();
        title = in.readString();
        artist = in.readString();
        duration = in.readInt();
        albumName = in.readString();
        albumCoverUrl = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(songId);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeInt(duration);
        dest.writeString(albumName);
        dest.writeString(albumCoverUrl);
    }
}