import model.ColorGrid;
import model.ColorNode;
import service.ColorGridService;
import service.ColorGridServiceImpl;

import java.util.*;

public class Color_Grid_Challenge {

    public static final int ROWS = 100;
    public static final int COLUMNS = 100;
    public static final String[] COLORS = {"RED", "BLUE", "GREEN"};

    public static void main(String[] args) {
        System.out.println("Starting Challenge");

        HashSet<ColorNode> processedNodes = new HashSet<>();
        Map<Integer, ColorNode> pendingNodes = new HashMap<>();

        ColorGridService service = new ColorGridServiceImpl(processedNodes, pendingNodes);
        LinkedList<ColorNode> colorGrid = service.createColorGrid(ROWS, COLUMNS, Arrays.asList(COLORS));
        ColorNode firstNode = colorGrid.get(0);
        ColorGrid grid = new ColorGrid(ROWS, COLUMNS, colorGrid);

        service.getAdjacentNodes(firstNode, grid);

        while (pendingNodes.size() > 0) {
            pendingNodes.forEach((k,v) -> {
                service.getAdjacentNodes(v,grid);
            });
        }


    }
}
