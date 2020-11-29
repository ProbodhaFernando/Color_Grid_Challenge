package service;

import model.ColorGrid;
import model.ColorNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface ColorGridService {
    LinkedList<ColorNode> createColorGrid(int numRows, int numCols, List<String> colors);

    void getAdjacentNodes(ColorNode colorNode, ColorGrid grid);

    void processAdjacentNode(ColorNode adjColorNode, ColorNode parentNode);
}
