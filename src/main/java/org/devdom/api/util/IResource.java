package org.devdom.api.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public final class IResource {
    
    private IResource(){
        throw new AssertionError();
    }

    public static final String API_PATH = "http://50.19.213.136:8080/skills-devdom/";

    public static final String[] URI = {
                                    "api/group",
                                    "api/group/by/id/:group-id",
                                    "api/influencer/top/general",
                                    "top/by/group/id/:group-id",
                                    "api/university",
                                    "api/university/page/:page-number",
                                    "api/university/id/:university-id",
                                    "api/category",
                                    "api/category/page/:page-number",
                                    "api/category/id/:category-id",
                                    "api/skill",
                                    "api/skill/page/:page-number",
                                    "api/skill/by/category/id/:category-id",
                                    "api/skill/by/category/id/:category-id/page/:page-number",
                                    "api/skill/id/:skill-id",
                                    "api/skill/where?votes_gt=:votes-gt",
                                    "api/skill/where?category_id=:category-id",
                                    "api/skill/where?limit=:top",
                                    "api/developer",
                                    "api/developer/page/:page-number",
                                    "api/developer/id/:developer-id",
                                    "api/developer/id/:developer-id/page/:page-number",
                                    "api/developer/where?first_name=:first-name",
                                    "api/developer/where?last_name=:last-name",
                                    "api/developer/where?sort=:sorting",
                                    "api/developer/where?limit=:top",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name&sort=:sorting",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name&sort=:sorting&limit=:top",
                                    "api/developer/by/university/id/:university_id",
                                    "api/developer/by/university/id/:university_id/page/:page-number"
                                };

    public static final String[] DESCRIPTION = {
        "Listado de los grupo de Developers DOminicanos",
        "Búsqueda de información de un grupo según su ID",
        "Top de los 20 developers más influyente tomando como base todos los grupos de desarrolladores del páis",
        "Top de los 20 developers más influyentes según el ID del grupo",
        "Listado de universidades",
        "Listado de universidades mostrando según la página indicada",
        "Retorna la información de una universidad según su ID",
        "Lista las categorías que contienen skills de developers",
        "Lista las categorías que contienen skills de developers especificando que página se espera mostrar",
        "Retorna información sobre una categoría según su id",
        "Lista todos los skills",
        "Lista todos los skills, indicando que página se desea mostrar",
        "Retorna skills de developer según el id de una categoría",
        "Retorna skills de developer según el id de una categoría y especificando que página se quiere ver",
        "Retornar detalle de un skill",
        "Retorna el listado de skills con parámetros combinados partiendo de un número mínimo de votos",
        "Retorna el listado de skills con parámetros combinados según el id de una categoría",
        "Retorna el listado de skills con parámetros combinados pudiendo indicar la máxima cantidad de elementos a mostrar",
        "Retornar el listado de developers",
        "Retornar el listado de developers, indicando la página que se desea mostrar",
        "Retorna información de un developer según su id",
        "Retorna información de un developer según su id y se especifica que página se desea mostrar",
        "Retorna el Listado de developers buscando coincidencias en el nombre",
        "Retorna el listado de developers buscando coincidencias en el apellido",
        "Retorna el listado de developers sorteando de forma ascendente o descendente",
        "Retorna el listado de developers limitando según el parámetro pasado",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo y sortear los resultados usando ASC o DESC",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo y sortear los resultados usando ASC o DESC y limitar la cantidad de resultados utilizando :limit",
        "Listado de developers según el ID de una universidad",
        "Listado de developers según el ID de una universidad y la página a mostrar"
    };

    public static final String getTag(String uri){
        String[] arr = uri.split("/");
        String v = "";
        for(String s : arr){
            try{
                v += s.substring(0,1);
            }catch(StringIndexOutOfBoundsException ex){}
        }
        return v.replace(":","").toLowerCase();
    }

    public static final String finalURL(String url){
        return url.replaceAll(":page-number","1") 
                  .replaceAll(":category-id","5") //category-id = (5) programming language
                  .replaceAll(":skill-id","8901") //skill-id = (8901) JBoss 
                  .replaceAll(":developer-id","1401") //developer-id = 1401
                  .replaceAll(":first-name","Melvyn")
                  .replaceAll(":last-name","P")
                  .replaceAll(":sorting","asc")
                  .replaceAll(":top","5")
                  .replaceAll(":university-id","1411")
                  .replaceAll(":votes-gt","300")
                  .replaceAll(":group-id", "201514949865358"); //group-id Developers Dominicanos por defecto
    }

}