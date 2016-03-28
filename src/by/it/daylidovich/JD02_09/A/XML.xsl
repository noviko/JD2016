<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/tours">
        <table border="1">
            <tr><td>Country</td><td>Cost</td><td>Transport</td><td>Hotel type</td><td>Food complex</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/tours/tour">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/tours/tour/country">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/tours/tour/cost">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/tours/tour/transport">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/tours/tour/hotel_type">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/tours/tour/food_complex">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>