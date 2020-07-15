package utils;

import entities.Abstract;
import entities.DataProvider;
import entities.Project;
import entities.Title;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDataExtractorTest {
    private String xml;
    private Project project;


    @BeforeEach
    void setUp() {
        System.out.println("before each");
        xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><fris:getProjectsResponse xmlns:crit=\"http://fris.ewi.be/criteria\" xmlns:resp=\"http://fris.ewi.be/response\" xmlns:fris=\"http://fris.ewi.be/\"><queryResult total=\"1\" pageSize=\"10\" pageNumber=\"0\"><fris:project uuid=\"6fa0f7de-4502-4995-92ae-5467e49df1b3\"><fris:rootOrganisationUuid>4811ac60-fe27-4bef-8e55-51079c3d9709</fris:rootOrganisationUuid><fris:state>PUBLIC</fris:state><fris:external>false</fris:external><fris:created>2018-11-15T10:02:27Z</fris:created><fris:lastModified>2019-01-02T11:33:50Z</fris:lastModified><fris:hidden>false</fris:hidden><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>54937891</fris:dataProviderId><fris:sources/><fris:aliases/><fris:name id=\"148096733\"><fris:texts><fris:text locale=\"en\">Structure-based discovery of positive allosteric modulators of the alpha7 nicotinic ecetylcholine receptor as cognition enhancers.</fris:text><fris:text locale=\"nl\">Structuur-gebaseerde ontwikkeling van positieve allostere modulatoren van de alpha7 nicotine acetylcholine receptor met klinische toepassing als cognitie verbeteraars.</fris:text></fris:texts></fris:name><fris:startDate>2018-07-02T00:00:00Z</fris:startDate><fris:endDate>2022-07-02T00:00:00Z</fris:endDate><fris:projectTypes><fris:type id=\"3985\" schemeId=\"Project Type\" schemeIdentifier=\"PROJECT_TYPE\" term=\"PhD\"/></fris:projectTypes><fris:projectAbstract id=\"148096734\"><fris:texts><fris:text locale=\"en\">&lt;p&gt;Nicotinic acetylcholine receptors (nAChRs) are relevant therapeutic targets for diseases of the brain. The most promising target for disorders associated with cognitive dysfunction is the alpha7 subtype. The scientific goal is to develop novel molecules targeting the α7 nicotinic acetylcholine receptor and that improve cognition in schizophrenia and Alzheimer’s disease, both of which are disorders for which there remains an unmet medical need. The main goal is to obtain a patent for the novel compounds and to negotiate a license with a pharmaceutical company. A 3-dimensional structure of the alpha7 subtype of nAChR is not yet available, but detailed insight of protein structures at atomic level yields invaluable information about protein function and can facilitate the discovery and development of new drugs. A marine snail protein (called acetylcholine binding protein) has been engineered to mimic the human alpha7 nAChR and offers a realistic template for structure-based drug design. The goal of this project is the development of novel high affinity lead compounds with activity as positive allosteric modulators for alpha7 nAChR. These compounds will have potential application as cognition enhancers in schizophrenia and Alheimer&amp;#39;s disease.&lt;/p&gt;</fris:text><fris:text locale=\"nl\">&lt;p&gt;Nicotine-acetylcholinereceptoren (nAChR&amp;#39;s) zijn relevante therapeutische doelen voor hersenziekten. Het meest veelbelovende doelwit voor aandoeningen geassocieerd met cognitieve dysfunctie is het alpha7-subtype. Het wetenschappelijke doel is om nieuwe moleculen te ontwikkelen die zich richten op de α7 nicotinische acetylcholinereceptor en die de cognitie verbeteren bij schizofrenie en de ziekte van Alzheimer, die beide stoornissen zijn waarvoor nog steeds een onvervulde medische behoefte bestaat. Het belangrijkste doel is om een patent te verkrijgen voor de nieuwe verbindingen en om een licentie te bedingen bij een farmaceutisch bedrijf. Een driedimensionale structuur van het alpha7-subtype van nahr is nog niet beschikbaar, maar gedetailleerd inzicht van eiwitstructuren op atomair niveau levert onschatbare informatie over de eiwitfunctie op en kan de ontdekking en ontwikkeling van nieuwe geneesmiddelen vergemakkelijken. Een marine slak-eiwit (acetylcholine-bindend eiwit genaamd) is ontwikkeld om de menselijke alfa7 nAChR na te bootsen en biedt een realistische sjabloon voor op structuur gebaseerd geneesmiddelenontwerp. Het doel van dit project is de ontwikkeling van nieuwe verbindingen met een hoge affiniteit met activiteit als positieve allosterische modulators voor alpha7 nAChR. Deze verbindingen zullen mogelijk worden toegepast als cognitie-versterkers bij schizofrenie en de ziekte van Alzheimer.&lt;/p&gt;</fris:text></fris:texts></fris:projectAbstract><fris:disciplines/><fris:flemishDisciplines><fris:flemishDisciplines id=\"144064956\" schemeId=\"Flemish Research Disciplines\" schemeIdentifier=\"FLEMISH_DISCIPLINE_CODE\" term=\"030123\"/><fris:flemishDisciplines id=\"144065247\" schemeId=\"Flemish Research Disciplines\" schemeIdentifier=\"FLEMISH_DISCIPLINE_CODE\" term=\"030623\"/><fris:flemishDisciplines id=\"144065337\" schemeId=\"Flemish Research Disciplines\" schemeIdentifier=\"FLEMISH_DISCIPLINE_CODE\" term=\"050103\"/><fris:flemishDisciplines id=\"144065343\" schemeId=\"Flemish Research Disciplines\" schemeIdentifier=\"FLEMISH_DISCIPLINE_CODE\" term=\"050105\"/><fris:flemishDisciplines id=\"144065346\" schemeId=\"Flemish Research Disciplines\" schemeIdentifier=\"FLEMISH_DISCIPLINE_CODE\" term=\"050106\"/></fris:flemishDisciplines><fris:fwoDisciplines/><fris:applicationCodes/><fris:technologyCodes/><fris:projectOrganisations/><fris:relatedProjects/><fris:participants><fris:participant id=\"148096737\"><fris:associationType id=\"1507082\" schemeId=\"Project Person Participant Role\" schemeIdentifier=\"PROJECT_PERSON_PARTICIPANT_ROLE\" term=\"Promoter\"/><fris:assignment id=\"77795057\"><fris:associationType id=\"3952\" schemeId=\"Assignment Role\" schemeIdentifier=\"PERSON_ORGANISATION_ASSOCIATION\" term=\"Member\"/><fris:organisation uuid=\"317477ac-865e-4e11-8c6d-62255b63f899\"><fris:external>false</fris:external><fris:hidden>false</fris:hidden><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>50753349</fris:dataProviderId><fris:sources/><fris:aliases/><fris:name><fris:texts><fris:text locale=\"en\">Laboratory of Structural Neurobiology</fris:text><fris:text locale=\"nl\">Laboratorium voor Structurele Neurobiologie</fris:text></fris:texts></fris:name><fris:organisationActivityTypes/><fris:nameVariants/><fris:relatedOrganisations/><fris:physicalAddresses/><fris:electronicAddresses/><fris:classifications/><fris:disciplines/><fris:flemishDisciplines/><fris:subjectAreas/></fris:organisation><fris:startDate>2007-10-01T00:00:00Z</fris:startDate><fris:endDate>9999-12-31T00:00:00Z</fris:endDate><fris:person uuid=\"d3bea6ae-7288-4ab4-99f9-ff8c9ac56eca\"><fris:external>false</fris:external><fris:hidden>false</fris:hidden><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>00018409</fris:dataProviderId><fris:sources/><fris:aliases/><fris:name><fris:firstName>Chris</fris:firstName><fris:lastName>Ulens</fris:lastName></fris:name><fris:nameVariants/><fris:relatedPersons/><fris:personOrganisations/><fris:scienceDomains/><fris:physicalAddresses/><fris:electronicAddresses/><fris:classifications/><fris:disciplines/><fris:flemishDisciplines/><fris:subjectAreas/></fris:person><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>00017871_50753349_M</fris:dataProviderId></fris:assignment><fris:startDate>2018-07-02T00:00:00Z</fris:startDate><fris:endDate>2022-07-02T00:00:00Z</fris:endDate></fris:participant><fris:participant id=\"148096738\"><fris:associationType id=\"1507080\" schemeId=\"Project Person Participant Role\" schemeIdentifier=\"PROJECT_PERSON_PARTICIPANT_ROLE\" term=\"Fellow\"/><fris:assignment id=\"130483819\"><fris:associationType id=\"3952\" schemeId=\"Assignment Role\" schemeIdentifier=\"PERSON_ORGANISATION_ASSOCIATION\" term=\"Member\"/><fris:organisation uuid=\"317477ac-865e-4e11-8c6d-62255b63f899\"><fris:external>false</fris:external><fris:hidden>false</fris:hidden><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>50753349</fris:dataProviderId><fris:sources/><fris:aliases/><fris:name><fris:texts><fris:text locale=\"en\">Laboratory of Structural Neurobiology</fris:text><fris:text locale=\"nl\">Laboratorium voor Structurele Neurobiologie</fris:text></fris:texts></fris:name><fris:organisationActivityTypes/><fris:nameVariants/><fris:relatedOrganisations/><fris:physicalAddresses/><fris:electronicAddresses/><fris:classifications/><fris:disciplines/><fris:flemishDisciplines/><fris:subjectAreas/></fris:organisation><fris:startDate>2018-07-01T00:00:00Z</fris:startDate><fris:endDate>9999-12-31T00:00:00Z</fris:endDate><fris:person uuid=\"5b14d4a8-e419-45d6-8484-d7e1b7e96b9f\"><fris:external>false</fris:external><fris:hidden>false</fris:hidden><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>00123174</fris:dataProviderId><fris:sources/><fris:aliases/><fris:name><fris:firstName>Diletta</fris:firstName><fris:lastName>Pasini</fris:lastName></fris:name><fris:nameVariants/><fris:relatedPersons/><fris:personOrganisations/><fris:scienceDomains/><fris:physicalAddresses/><fris:electronicAddresses/><fris:classifications/><fris:disciplines/><fris:flemishDisciplines/><fris:subjectAreas/></fris:person><fris:dataProvider>KULeuven</fris:dataProvider><fris:dataProviderId>00177544_50753349_M</fris:dataProviderId></fris:assignment><fris:startDate>2018-07-02T00:00:00Z</fris:startDate><fris:endDate>2022-07-02T00:00:00Z</fris:endDate></fris:participant></fris:participants><fris:projectFunding><fris:projectFunding id=\"148096739\"><fris:fundingCode code=\"1000\"><fris:description><fris:texts><fris:text locale=\"en\">Own budget, for example: patrimony, inscription fees, gifts</fris:text><fris:text locale=\"nl\">Eigen Middelen zoals patrimonium, inschrijvingsgelden, giften, ....</fris:text></fris:texts></fris:description><fris:fundingOrganisationAssociations/><fris:policyLevels/><fris:researchTypes/></fris:fundingCode><fris:fundingRole id=\"3365\" schemeId=\"Funding Source to Project Role\" schemeIdentifier=\"FUNDING_ROLE\" term=\"Principal Funding\"/><fris:startDate>2018-07-02T00:00:00Z</fris:startDate><fris:endDate>2022-07-02T00:00:00Z</fris:endDate><fris:budgetLines/></fris:projectFunding></fris:projectFunding><fris:fundingIdentifiers/><fris:subjectAreas><fris:subjectArea id=\"76649996\" schemeId=\"Subject Area Codes\" schemeIdentifier=\"SUBJECT_AREA\" term=\"B640\"/></fris:subjectAreas><fris:keywords><fris:keyword locale=\"en\">Ion channels</fris:keyword><fris:keyword locale=\"en\">Positive allosteric modulators</fris:keyword><fris:keyword locale=\"en\">Crystallography</fris:keyword></fris:keywords></fris:project></queryResult></fris:getProjectsResponse></soap:Body></soap:Envelope>";
        project = ProjectDataExtractor.getProjectData(xml).get(0);
    }

    @Test
    void getProjectData() {
        assertFalse(project.isEmpty());
    }

    @Test
    void getProjectId(){
        assertEquals("6fa0f7de-4502-4995-92ae-5467e49df1b3", project.getId().toString());
    }

    @Test
    void getProjectKeywords(){
        ArrayList<String> englishKeywords = new ArrayList<>();
        englishKeywords.add("Ion channels");
        englishKeywords.add("Positive allosteric modulators");
        englishKeywords.add("Crystallography");

        assertEquals(englishKeywords, project.getEnglishKeywords());
        assertTrue(project.getDutchKeywords().isEmpty());
    }

    @Test
    void getProjectDataProvider(){
        DataProvider dp = new DataProvider("54937891", "KULeuven");

        assertEquals(dp, project.getDataProvider());
    }

    @Test
    void getProjectTitle(){
        Title t = new Title("Structure-based discovery of positive allosteric modulators of the alpha7 nicotinic ecetylcholine receptor as cognition enhancers.", "Structuur-gebaseerde ontwikkeling van positieve allostere modulatoren van de alpha7 nicotine acetylcholine receptor met klinische toepassing als cognitie verbeteraars.");

        assertEquals(t, project.getTitle());
    }

    @Test
    void getProjectAbstract(){
        // abstract formatting issues are solved by data cleaning
        Abstract a = new Abstract(148096734, "", "");

        assertEquals(a, project.getAbstract());
    }
}