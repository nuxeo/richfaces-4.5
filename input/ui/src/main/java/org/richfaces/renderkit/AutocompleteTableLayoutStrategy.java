package org.richfaces.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;


public class AutocompleteTableLayoutStrategy extends AbstractAutocompleteLayoutStrategy implements
    AutocompleteEncodeStrategy {

    public void encodeFakeItem(FacesContext facesContext, UIComponent component) throws IOException {
        ResponseWriter responseWriter = facesContext.getResponseWriter();
        responseWriter.startElement(HtmlConstants.TR_ELEMENT, component);
        responseWriter.startElement(HtmlConstants.TD_ELEM, component);
        responseWriter.writeAttribute(HtmlConstants.STYLE_ATTRIBUTE, "display:none", null);
        responseWriter.endElement(HtmlConstants.TD_ELEM);
        responseWriter.endElement(HtmlConstants.TR_ELEMENT);

    }

    public void encodeItemsContainerBegin(FacesContext facesContext, UIComponent component) throws IOException {
        ResponseWriter responseWriter = facesContext.getResponseWriter();
        responseWriter.startElement(HtmlConstants.TABLE_ELEMENT, component);
        responseWriter.writeAttribute(HtmlConstants.ID_ATTRIBUTE, getContainerElementId(facesContext, component), null);
        responseWriter.startElement(HtmlConstants.TBODY_ELEMENT, component);
    }

    public void encodeItemsContainerEnd(FacesContext facesContext, UIComponent component) throws IOException {
        ResponseWriter responseWriter = facesContext.getResponseWriter();
        responseWriter.endElement(HtmlConstants.TBODY_ELEMENT);
        responseWriter.endElement(HtmlConstants.TABLE_ELEMENT);
    }
    
    public void encodeItemBegin(FacesContext facesContext, UIComponent component) throws IOException {
    	ResponseWriter writer = facesContext.getResponseWriter();
        writer.startElement(HtmlConstants.TR_ELEMENT, component);
        writer.startElement(HtmlConstants.TD_ELEM, component);
    }
    
    public void encodeItemEnd(FacesContext facesContext, UIComponent component) throws IOException {
        ResponseWriter writer = facesContext.getResponseWriter();
        writer.endElement(HtmlConstants.TD_ELEM);
        writer.endElement(HtmlConstants.TR_ELEMENT);
    }

}
