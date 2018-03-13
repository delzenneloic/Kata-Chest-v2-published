package files;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import board.Board;
import board.Position;
import pawn.AbstractPawn;

public class Reader {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document xml;
	Element root;
    XPathFactory xpf;
    XPath path;
    
	public Reader(String filename) {
		factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File fileXML = new File(filename);
		try {
			xml = builder.parse(fileXML);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		
		root = xml.getDocumentElement();
        xpf = XPathFactory.newInstance();
        path = xpf.newXPath();
	}
	
	public Board board() {
		Board board = new Board();
		
		XPathExpression exp = null;
		try {
			exp = path.compile("//chess/board/pawns/pawn");
		} catch (XPathExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// The xpath expression must be tested and working.
		// If not, there is no point to continue.
		
		NodeList pawnsList = null;
		try {
			pawnsList = (NodeList)exp.evaluate(xml, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0; i< pawnsList.getLength(); ++i) {
			if (pawnsList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Node node = pawnsList.item(i);
				String type = ((Element)node).getAttribute("type");
				String color = ((Element)node).getAttribute("color");
				String reference = ((Element)node).getAttribute("position");
				
				AbstractPawn p = PawnBuilder.build(type, color);
				Position q = Board.position(reference);
				
				board.setPawn(q, p);
			}
		}
		
		return board;
	}
}
