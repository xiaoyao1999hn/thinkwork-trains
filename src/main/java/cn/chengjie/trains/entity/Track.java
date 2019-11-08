package cn.chengjie.trains.entity;

import java.io.*;
/**
 * 路径实体类
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:33
 **/
public class Track implements Cloneable,Serializable {

    private static final long serialVersionUID = 5468335797443850679L;

    /**
     * 开始节点
     */
    String start;

    /**
     * 路径
     */
    StringBuffer path;

    /**
     * 距离
     */
    int pathDistance;

    public Track(String start) {
        this.start = start;
        path = new StringBuffer();
        path.append(start);
        pathDistance = 0;
    }

    /**
     * 更新路径并统计距离
     * @param edge
     */
    public void refreshTrack(Edge edge){
        this.pathDistance +=edge.getDistance();
        this.path.append(edge.getEnd());
    }

    public StringBuffer getPath() {
        return path;
    }

    public void setPath(StringBuffer path) {
        this.path = path;
    }

    public int getPathDistance() {
        return pathDistance;
    }

    public void setPathDistance(int pathDistance) {
        this.pathDistance = pathDistance;
    }


    /**
     * 这里采用深拷贝
     * @return
     */
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
