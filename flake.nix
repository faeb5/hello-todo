{
  description = "Generic Java development environment";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
  };

  outputs = {
    self,
    nixpkgs,
  }: let
    pkgs = nixpkgs.legacyPackages.x86_64-linux;
  in {
    devShells.x86_64-linux.default = with pkgs;
      mkShellNoCC {
        buildInputs = with pkgs; [jdk8 maven];
        packages = with pkgs; [jdt-language-server lombok google-java-format insomnia];
        LOMBOK_HOME = "${lombok}/share/java";
        shellHook = ''echo "Welcome to the generic Java development environment"'';
      };
  };
}
