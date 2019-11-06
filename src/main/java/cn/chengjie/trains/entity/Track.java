package cn.chengjie.trains.entity;

import java.io.*;
/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:33
 **/
public class Track implements Cloneable,Serializable {

    private static final long serialVersionUID = 5468335797443850679L;

    String start;

//    List<String> path;
    StringBuffer path;

    int count;

    public Track(String start) {
        this.start = start;
        path = new StringBuffer();
        path.append(start);
        count = 0;
    }

    public StringBuffer getPath() {
        return path;
    }

    public void setPath(StringBuffer path) {
        this.path = path;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public Track clone() {
        ByteArrayOutputStream byteOut = null;
        ObjectOutputStream out = null;
        ByteArrayInputStream byteIn = null;
        ObjectInputStream in = null;
        try {
            byteOut = new ByteArrayOutputStream();
            out = new ObjectOutputStream(byteOut);
            out.writeObject(this);
            byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            in = new ObjectInputStream(byteIn);
            return (Track) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (byteIn != null) {
                try {
                    byteIn.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
            if (byteOut != null) {
                try {
                    byteOut.close();
                } catch (IOException e) {
                }
            }
        }
        return new Track(start);
    }
}