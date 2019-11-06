package cn.chengjie.trains;

//import cn.chengjie.trains.core.Graph;
//import cn.chengjie.trains.domain.Edge;
//import cn.chengjie.trains.handler.*;
//
//import java.util.Arrays;
//import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 9:56
 * @description：
 */
public class App {

    public static void main(String[] args) {

//        new Graph.Builder()
//
//        List<Edge> stationList = Arrays.asList(new Edge("A", "B", 5), new Edge("B", "C", 4), new Edge("C", "D", 8),
//                new Edge("D", "C", 8), new Edge("D", "E", 6), new Edge("A", "D", 5), new Edge("C", "E", 2),
//                new Edge("E", "B", 3), new Edge("A", "E", 7));
//
//        List<List<String>> inputList = Arrays.asList(Arrays.asList("A", "B", "C"), Arrays.asList("A", "D"),
//                Arrays.asList("A", "D", "C"), Arrays.asList("A", "E", "B", "C", "D"), Arrays.asList("A", "E", "D"));
//
//        AbstractTrainClient client = new DefaultTrainClient();
//        AbstractDistanceHandler distanceHandler = new DefaultDistanceHandler(stationList);
//        RouteHandler routeHandler = new DefaultRouteHandler(stationList);
//
//        client.setDistanceHandler(distanceHandler);
//        client.setRouteHandler(routeHandler);
//
//
//        int index = 0;
//        int distance = 0;
//        for (List<String> input : inputList) {
//            distance = client.getDistance(input);
//            index++;
//            System.out.println("Output #" + index + ":" + (distance == -1 ? "NO SUCH ROUTE" : distance));
//        }
//
//        System.out.println("Output #6:" + client.getRouteCount("C", "C"));
//        System.out.println("Output #7:" + client.getRouteCount("A", "C"));
//        System.out.println("Output #8:" + client.getShortestDistance("A", "C"));
//        System.out.println("Output #9:" + client.getShortestDistance("B", "B"));
//        System.out.println("Output #10:" + client.getRouteCount("C", "C"));
    }
}
