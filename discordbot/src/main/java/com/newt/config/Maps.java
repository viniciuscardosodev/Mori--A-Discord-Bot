package com.newt.config;

public enum Maps {
    
        ASCENT(0, "Ascent", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt29545c241f79b04c/5eb351b41fca102e28a1b974/ascent-featured.png"),
        SPLIT(1, "Split", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltd188c023f88f7d91/5ebc46db20f7727335261fcd/split-featured.png"),
        BIND(2, "Bind", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt8538036a309525ae/5ebc470bfd85ad7411ce6b50/bind-featured.png"),
        HAVEN(3, "Haven", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt8afb5b8145f5e9b2/5ebc46f7b8c49976b71c0bc5/haven-featured.png"),
        ICEBOX(4, "Icebox", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltde02911a015d7ef9/5f80d2851f5f6d4173b4e49d/Icebox_transparentbg_for_Web.png"),
        BREEZE(5, "Breeze", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb03d2e4867f2e324/607f995892f0063e5c0711bd/breeze-featured_v1.png"),
        FRACTURE(6, "Fracture", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltf4485163c8c5873c/6131b23e9db95e7ff74b6393/Valorant_FRACTURE_Minimap_Alpha_web.png"),
        PEARL(7, "Pearl", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltd0a2437fb09ebde4/62a2805b58931557ed9f7c9e/PearlLoadingScreen_MapFeaturedImage_930x522.png"),
        LOTUS(8, "Lotus", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltaae67d0ec5006ef5/63b8a78d28c9fb7a1880a9e2/Lotus_MapWebsite_Web.png"),
        SUNSET(9, "Sunset", "https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt9053fb44094718e6/64e934091ab3c3ccb703dd43/SUNSET_LoadingScreen_Desktop.png");
    
        private final int index;
        private final String string1;
        private final String string2;
    
        Maps(int index, String string1, String string2) {
            this.index = index;
            this.string1 = string1;
            this.string2 = string2;
        }
    
        public int getIndex() {
            return index;
        }
    
        public String getString1() {
            return string1;
        }
    
        public String getString2() {
            return string2;
        }

        public static Maps getByIndex(int index) {
            for (Maps value : Maps.values()) {
                if (value.getIndex() == index) {
                    return value;
                }
            }
            throw new IllegalArgumentException("Invalid index: " + index);
        }
}
