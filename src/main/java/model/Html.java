package model;

public class Html {
    private static String content = "<div class=\"onibus\">\n" +
            "        <div onclick=\"window.open('?lugar=1','_self')\" class=\"bancos\">1</div>\n" +
            "        <div onclick=\"window.open('/3','_self')\" class=\"bancos\">3</div>\n" +
            "        <div onclick=\"window.open('/5','_self')\" class=\"bancos\">5</div>\n" +
            "        <div onclick=\"window.open('/7','_self')\" class=\"bancos\">7</div>\n" +
            "        <div onclick=\"window.open('/9','_self')\" class=\"bancos\">9</div>\n" +
            "        <div onclick=\"window.open('/11','_self')\" class=\"bancos\">11</div>\n" +
            "        <div onclick=\"window.open('/13','_self')\" class=\"bancos\">13</div>\n" +
            "        <div onclick=\"window.open('/15','_self')\" class=\"bancos\">15</div>\n" +
            "        <div onclick=\"window.open('/17','_self')\" class=\"bancos\">17</div>\n" +
            "        <div onclick=\"window.open('/19','_self')\" class=\"bancos\">19</div>\n" +
            "        <div onclick=\"window.open('/21','_self')\" class=\"bancos\">21</div>\n" +
            "        <div onclick=\"window.open('/13','_self')\" class=\"bancos\">23</div>\n" +
            "        <div onclick=\"window.open('/25','_self')\" class=\"bancos\">25</div>\n" +
            "        <div onclick=\"window.open('/2','_self')\" class=\"bancos\">2</div>\n" +
            "        <div onclick=\"window.open('/4','_self')\" class=\"bancos\">4</div>\n" +
            "        <div onclick=\"window.open('/6','_self')\" class=\"bancos\">6</div>\n" +
            "        <div onclick=\"window.open('/8','_self')\" class=\"bancos\">8</div>\n" +
            "        <div onclick=\"window.open('/10','_self')\" class=\"bancos\">10</div>\n" +
            "        <div onclick=\"window.open('/12','_self')\" class=\"bancos\">12</div>\n" +
            "        <div onclick=\"window.open('/14','_self')\" class=\"bancos\">14</div>\n" +
            "        <div onclick=\"window.open('/16','_self')\" class=\"bancos\">16</div>\n" +
            "        <div onclick=\"window.open('/18','_self')\" class=\"bancos\">18</div>\n" +
            "        <div onclick=\"window.open('/20','_self')\" class=\"bancos\">20</div>\n" +
            "        <div onclick=\"window.open('/22','_self')\" class=\"bancos\">22</div>\n" +
            "        <div onclick=\"window.open('/24','_self')\" class=\"bancos\">24</div>\n" +
            "        <div onclick=\"window.open('/26','_self')\" class=\"bancos\">26</div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div class=\"corredor\"></div>\n" +
            "        <div onclick=\"window.open('/27','_self')\" class=\"bancos\">27</div>\n" +
            "        <div onclick=\"window.open('/29','_self')\" class=\"bancos\">29</div>\n" +
            "        <div onclick=\"window.open('/31','_self')\" class=\"bancos\">31</div>\n" +
            "        <div onclick=\"window.open('/33','_self')\" class=\"bancos\">33</div>\n" +
            "        <div onclick=\"window.open('/35','_self')\" class=\"bancos\">35</div>\n" +
            "        <div onclick=\"window.open('/37','_self')\" class=\"bancos\">37</div>\n" +
            "        <div onclick=\"window.open('/39','_self')\" class=\"bancos\">39</div>\n" +
            "        <div onclick=\"window.open('/41','_self')\" class=\"bancos\">41</div>\n" +
            "        <div onclick=\"window.open('/42','_self')\" class=\"bancos\">43</div>\n" +
            "        <div onclick=\"window.open('/45','_self')\" class=\"bancos\">45</div>\n" +
            "        <div onclick=\"window.open('/57','_self')\" class=\"bancos\">47</div>\n" +
            "        <div onclick=\"window.open('/49','_self')\" class=\"bancos\">49</div>\n" +
            "        <div onclick=\"window.open('/51','_self')\" class=\"bancos\">51</div>\n" +
            "        <div onclick=\"window.open('/28','_self')\" class=\"bancos\">28</div>\n" +
            "        <div onclick=\"window.open('/30','_self')\" class=\"bancos\">30</div>\n" +
            "        <div onclick=\"window.open('/32','_self')\" class=\"bancos\">32</div>\n" +
            "        <div onclick=\"window.open('/35','_self')\" class=\"bancos\">34</div>\n" +
            "        <div onclick=\"window.open('/36','_self')\" class=\"bancos\">36</div>\n" +
            "        <div onclick=\"window.open('/38','_self')\" class=\"bancos\">38</div>\n" +
            "        <div onclick=\"window.open('/40','_self')\" class=\"bancos\">40</div>\n" +
            "        <div onclick=\"window.open('/42','_self')\" class=\"bancos\">42</div>\n" +
            "        <div onclick=\"window.open('/44','_self')\" class=\"bancos\">44</div>\n" +
            "        <div onclick=\"window.open('/46','_self')\" class=\"bancos\">46</div>\n" +
            "        <div onclick=\"window.open('/48','_self')\" class=\"bancos\">48</div>\n" +
            "        <div onclick=\"window.open('/50','_self')\" class=\"bancos\">50</div>\n" +
            "        <div onclick=\"window.open('/52','_self')\" class=\"bancos\">52</div>\n" +
            "        \n" +
            "        \n" +
            "    </div>";

    private static String style = ".onibus{\n" +
            "        width: 1150px;\n" +
            "        height: 330px;\n" +
            "        margin-left: 55px;\n" +
            "        margin-top: 200px;\n" +
            "        border-style: solid;\n" +
            "        \n" +
            "        \n" +
            "        \n" +
            "    }\n" +
            "\n" +
            "    .bancos{\n" +
            "        background-color: #20B2AA;\n" +
            "        width: 70px;\n" +
            "        height: 50px;\n" +
            "        margin: 8px;\n" +
            "        float: left;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    .corredor{\n" +
            "        background-color: #fff;\n" +
            "        width: 70px;\n" +
            "        height: 50px;\n" +
            "        margin: 8px;\n" +
            "        float: left;\n" +
            "    }";
    private static String body = "<!DOCTYPE Html>\n" +
            "<Html lang =" + "pt-BR" + ">\n" +
            "<head>\n" +
            "<style>\n"+
            style+
            "</style>\n"+
            "\t<title>Sistema de Reservas</title>\n" +
            "</head>\n" +
            "<content>\n" +
            content +
            "</content>"+"</Html>";


    public void setBody(String body) {
        this.content = body;
    }

    public static String getBody() {
        return body;
    }

}