ALTER TABLE public.funcionario
ADD CONSTRAINT fk_cargo
FOREIGN KEY (fk_cargo) REFERENCES public.cargo (idcargo);

ALTER TABLE public.funcionario
ADD CONSTRAINT fk_setor
FOREIGN KEY (fk_setor) REFERENCES public.setor (idsetor);

ALTER TABLE public.material
ADD CONSTRAINT fk_setor
FOREIGN KEY (fk_setor) REFERENCES public.setor (idsetor);

ALTER TABLE public.material
ADD CONSTRAINT fk_materialtipo
FOREIGN KEY (fk_materialtipo) REFERENCES public.materialtipo (idmaterialtipo);

ALTER TABLE public.material
ADD CONSTRAINT fk_status
FOREIGN KEY (fk_status) REFERENCES public.materialstatus (idmaterialstatus);

ALTER TABLE public.material
ADD CONSTRAINT fk_categoria
FOREIGN KEY (fk_categoria) REFERENCES public.categoria (idcategoria);

ALTER TABLE public.solicitacao
ADD CONSTRAINT fk_funcionario
FOREIGN KEY (fk_funcionario) REFERENCES public.funcionario (idfuncionario);

ALTER TABLE public.solicitacao
ADD CONSTRAINT fk_solicitacaostatus
FOREIGN KEY (fk_solicitacaostatus) REFERENCES public.solicitacaostatus (idsolicitacaostatus);

ALTER TABLE public.historico
ADD CONSTRAINT fk_solicitacao
FOREIGN KEY (fk_solicitacao) REFERENCES public.solicitacao (idsolicitacao);

ALTER TABLE public.solicitacaoitem
ADD CONSTRAINT fk_solicitacao
FOREIGN KEY (fk_solicitacao) REFERENCES public.solicitacao (idsolicitacao);

ALTER TABLE public.solicitacaoitem
ADD CONSTRAINT fk_material
FOREIGN KEY (fk_material) REFERENCES public.material (idmaterial);