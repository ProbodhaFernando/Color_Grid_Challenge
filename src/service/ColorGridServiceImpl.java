package service;

import model.ColorGrid;
import model.ColorNode;

import java.util.*;

public class ColorGridServiceImpl implements ColorGridService {

    private HashSet<ColorNode> processedNodes;
    private Map<Integer, ColorNode> pendingNodes;
    private Map<String, Integer> colorMatchedIndex;

    public ColorGridServiceImpl(HashSet<ColorNode> processedNodes, Map<Integer, ColorNode> pendingNodes) {
        this.processedNodes = processedNodes;
        this.pendingNodes = pendingNodes;
        this.colorMatchedIndex = new HashMap<>();
    }

    @Override
    public LinkedList<ColorNode> createColorGrid(int numRows, int numCols, List<String> colors) {
        return null;
    }

    @Override
    public void getAdjacentNodes(ColorNode colorNode, ColorGrid grid) {
        LinkedList<ColorNode> colorGrid = grid.getGrid();
        ColorNode parentNode = colorGrid.get(colorNode.getIndex());
        int row = colorNode.getRow();
        int col = colorNode.getCol();

        // TOP EDGE ELEMENTS
        if (col < grid.getNumCols()) {
            ColorNode adjNodeToRight = colorGrid.get(colorNode.getIndex() + 1);
            ColorNode adjNodeToBottom = colorGrid.get(colorNode.getIndex()+colorNode.getCol());
            processAdjacentNode(adjNodeToRight, parentNode);
            processAdjacentNode(adjNodeToBottom, parentNode);
        }

        // RIGHT EGDE ELEMENTS
        if (col == grid.getNumCols()) {
            // Remove the parentNode from PendingNodesList
            pendingNodes.remove(parentNode.getIndex());
        }

        // BOTTOM EGDE ELEMENTS
        if (row == grid.getNumRows()) {
            // Remove the parentNode from PendingNodesList
            pendingNodes.remove(parentNode.getIndex());
        }

        // LAST ELEMENT OF THE GRID
        if ((colorGrid.size()-1) == colorNode.getIndex()) {

        }
    }

    @Override
    public void processAdjacentNode(ColorNode adjColorNode, ColorNode parentNode) {
        if (!processedNodes.contains(adjColorNode)) {
            processedNodes.add(adjColorNode);// Add to Processed Nodes List

            if (parentNode.getColor().equals(adjColorNode.getColor())) {
                // increase Colour index count if matched color node found
                Integer count = colorMatchedIndex.get(parentNode.getColor());
                colorMatchedIndex.put(parentNode.getColor(), (count == null) ? 0 : (count + 1));
            }

            if (!pendingNodes.containsKey(adjColorNode.getIndex())) {
                pendingNodes.put(adjColorNode.getIndex(), adjColorNode); // Add AdjacentNode to Pending nodes list
            }

            if (pendingNodes.containsKey(parentNode.getIndex())) {
                pendingNodes.remove(parentNode.getIndex()); // Remove processed ParentNode from pendingNodes list
            }
        }
    }
}
