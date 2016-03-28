<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/project">
        <h1>
            Project "Hotel"
        </h1>
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/project/rooms">
        <table border="1">
            <tr><td>Number</td><td>People quantity</td><td>Bed Size</td><td>Seaview</td><td>Floor</td><td>Price</td><td>air-conditioner</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/project/rooms/room">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/project/rooms/room/room_number">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/people_quantity">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/bed_size">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/seaview">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/floor">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/rooms/room/air_conditioner">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications">
        <table border="1">
            <tr><td>Number of Application</td><td>Surname</td><td>Name</td><td>Quest quantity</td><td>Phone number</td><td>Mail</td><td>Extra requirement</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/project/applications/application">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/project/applications/application/application_number">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/surname">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/quest_quantity">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/phone_number">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/mail">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/project/applications/application/extrarequirement">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>