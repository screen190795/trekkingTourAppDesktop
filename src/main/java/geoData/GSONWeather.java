
package geoData;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class GSONWeather implements Serializable {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Integer visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;
    private final static long serialVersionUID = 1417010765473779007L;

    /**
     * No args constructor for use in serialization
     */
    public GSONWeather() {
    }

    /**
     * @param visibility
     * @param timezone
     * @param main
     * @param clouds
     * @param sys
     * @param dt
     * @param coord
     * @param weather
     * @param name
     * @param cod
     * @param id
     * @param base
     * @param wind
     */
    public GSONWeather(Coord coord, List<Weather> weather, String base, Main main, Integer visibility, Wind wind, Clouds clouds, Integer dt, Sys sys, Integer timezone, Integer id, String name, Integer cod) {
        super();
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public GSONWeather withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public GSONWeather withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public GSONWeather withBase(String base) {
        this.base = base;
        return this;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public GSONWeather withMain(Main main) {
        this.main = main;
        return this;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public GSONWeather withVisibility(Integer visibility) {
        this.visibility = visibility;
        return this;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public GSONWeather withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public GSONWeather withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public GSONWeather withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public GSONWeather withSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public GSONWeather withTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GSONWeather withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GSONWeather withName(String name) {
        this.name = name;
        return this;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public GSONWeather withCod(Integer cod) {
        this.cod = cod;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("coord", coord).append("weather", weather).append("base", base).append("main", main).append("visibility", visibility).append("wind", wind).append("clouds", clouds).append("dt", dt).append("sys", sys).append("timezone", timezone).append("id", id).append("name", name).append("cod", cod).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(visibility).append(timezone).append(main).append(clouds).append(sys).append(dt).append(coord).append(weather).append(name).append(cod).append(id).append(base).append(wind).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GSONWeather) == false) {
            return false;
        }
        GSONWeather rhs = ((GSONWeather) other);
        return new EqualsBuilder().append(visibility, rhs.visibility).append(timezone, rhs.timezone).append(main, rhs.main).append(clouds, rhs.clouds).append(sys, rhs.sys).append(dt, rhs.dt).append(coord, rhs.coord).append(weather, rhs.weather).append(name, rhs.name).append(cod, rhs.cod).append(id, rhs.id).append(base, rhs.base).append(wind, rhs.wind).isEquals();
    }

    public GSONWeather getForecastByCoordinates(GeoPoint geoPoint) throws IOException {
        String appId = "1b0f31aa5e488513d407da0078685072";
        String sURL = "https://api.openweathermap.org/data/2.5/weather?lat="+geoPoint.latitude+"&lon="+geoPoint.longitude+"&appid="+appId;
        System.out.println(sURL);
        URLConnection connection = null;
            connection = new URL(sURL).openConnection();
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;
            StringBuilder sb = new StringBuilder();
            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);
            reader.close();
            String jsonString = sb.toString();
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            GSONWeather gsonWeather = gson.fromJson(jsonString, GSONWeather.class);
            return gsonWeather;

    }


}




