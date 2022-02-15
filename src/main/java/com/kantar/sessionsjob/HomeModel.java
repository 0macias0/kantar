package com.kantar.sessionsjob;

public class HomeModel
{
    private String homeNo;
    private String channel;
    private String starttime;
    private String activity;

    private long duration;
    private String endTime;

    public HomeModel(String homeNo, String channel, String starttime, String activity)
    {
        this.homeNo = homeNo;
        this.channel = channel;
        this.starttime = starttime;
        this.activity = activity;
    }

    public String toPsVRow(){
        return String.join("|", homeNo, channel, starttime, activity, endTime, Long.toString(duration));
    }

    public String getHomeNo()
    {
        return homeNo;
    }

    public void setHomeNo(String homeNo)
    {
        this.homeNo = homeNo;
    }

    public String getChannel()
    {
        return channel;
    }

    public void setChannel(String channel)
    {
        this.channel = channel;
    }

    public String getStarttime()
    {
        return starttime;
    }

    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }

    public String getActivity()
    {
        return activity;
    }

    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    public long getDuration()
    {
        return duration;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
}
