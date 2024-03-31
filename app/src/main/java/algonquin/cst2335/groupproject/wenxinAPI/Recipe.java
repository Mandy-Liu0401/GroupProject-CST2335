package algonquin.cst2335.groupproject.wenxinAPI;

import android.os.Parcel;
import android.os.Parcelable;


import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.PrimaryKey;
/**
 *
 * Entity class representing a recipe in the database.
 * This class is annotated with {@link Entity}, indicating that it's a table within the Room database.
 * It includes fields that represent the properties of a recipe, such as its ID, title, image URL, summary, and source URL.
 * Getters and setters are provided for each property to allow for encapsulation and easy data access.
 *
 * @author  Wenxin Li
 * @version 1.6
 * @since   2024-03-27
 */
@Entity
public class Recipe implements Parcelable {
    /**
     * Unique identifier for each recipe entry. It is auto-generated by the database.
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    /**
     * External recipe ID, potentially used to reference data from an external API.
     */
    @ColumnInfo(name = "RecipeID")
    protected int recipeID;

    /**
     * The title of the recipe.
     */
    @ColumnInfo(name = "Title")
    protected String title;

    /**
     * URL to an image of the recipe.
     */
    @ColumnInfo(name="ImageURL")
    protected String imageURL;

    /**
     * Summary or description of the recipe.
     */
    @ColumnInfo(name="Summary")
    protected String summary;

    /**
     * URL to the original source of the recipe.
     */
    @ColumnInfo(name = "SourceURL")
    protected String sourceURL;

    /**
     * Default constructor required for Room to create Recipe instances.
     */
    public Recipe(){
    }
    /**
     * Constructor to create a new Recipe instance with specific details.
     *
     * @param title The title of the recipe.
     * @param imageURL URL to an image of the recipe.
     * @param summary Summary or description of the recipe.
     * @param sourceURL URL to the original source of the recipe.
     * @param recipeID External recipe ID.
     */
    public Recipe( String title, String imageURL, String summary, String sourceURL,int recipeID) {

        this.title=title;
        this.imageURL=imageURL;
        this.summary=summary;
        this.sourceURL=sourceURL;
        this.recipeID=recipeID;
    }

    /**
     * Gets the unique identifier for this recipe.
     *
     * @return The unique ID of the recipe.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this recipe. Typically not set manually as IDs are auto-generated by the database.
     *
     * @param id The unique ID to set for the recipe.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the external recipe ID. This ID might be used for referencing recipes from an external data source.
     *
     * @return The external recipe ID.
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * Sets the external recipe ID. This can be used to associate the recipe with an external data source.
     *
     * @param recipeID The external recipe ID to set.
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    /**
     * Gets the title of the recipe.
     *
     * @return The title of the recipe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the recipe. The title should succinctly describe the recipe.
     *
     * @param title The title to set for the recipe.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the URL to an image of the recipe. This image is intended to visually represent the recipe.
     *
     * @return The URL to the recipe's image.
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Sets the URL to an image of the recipe. Provide a URL that points to a relevant and high-quality image.
     *
     * @param imageURL The URL to set for the recipe's image.
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Gets the summary or description of the recipe. This summary provides a brief overview of the recipe.
     *
     * @return The summary of the recipe.
     */
    public String getSummary() {
        return summary;
    }
    /**
     * Sets the summary or description of the recipe. The summary should provide essential information about the recipe.
     *
     * @param summary The summary to set for the recipe.
     */

    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the URL to the original source of the recipe. This can be a link to a webpage where the recipe was originally published.
     *
     * @return The URL to the original source of the recipe.
     */
    public String getSourceURL() {
        return sourceURL;
    }
    /**
     * Sets the URL to the original source of the recipe. This provides a way to credit the original creator of the recipe.
     *
     * @param sourceURL The URL to set as the source of the recipe.
     */
    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }


    protected Recipe(Parcel in) {
        this.id = in.readInt();
        this.recipeID = in.readInt();
        this.title = in.readString();
        this.imageURL = in.readString();
        this.summary = in.readString();
        this.sourceURL = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.recipeID);
        dest.writeString(this.title);
        dest.writeString(this.imageURL);
        dest.writeString(this.summary);
        dest.writeString(this.sourceURL);
    }
    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
