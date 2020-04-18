import React, { useState, useEffect } from "react";
import { useParams, useHistory } from "react-router-dom";
import { ajax } from "rxjs/ajax";
import { map } from "rxjs/operators";
import { BASE_URL, API_ENDPOINTS } from "../../endpoints";

import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Axios from "axios";

function FormProdutos() {
  const criaFormEmBranco = () => {
    return {
      name: "",
      value: 0.0,
      image: "",
    };
  };

  const [form, setForm] = useState(criaFormEmBranco());
  const { idProduto } = useParams();
  const history = useHistory();

  useEffect(() => {
    if (idProduto !== undefined) {
      ajax(`${BASE_URL + API_ENDPOINTS.product}/${idProduto}`)
        .pipe(map((ajaxResponse) => ajaxResponse.response))
        .subscribe((x) => setForm(x));
    }
  }, [idProduto]);

  const setValor = (evento, campo) => {
    setForm({ ...form, [campo]: evento.target.value });
  };

  const submeter = (evento) => {
    evento.preventDefault();
    if (idProduto === undefined) {
      Axios.post(BASE_URL + API_ENDPOINTS.product, form);
      history.push("/produtos");
    } else {
      Axios.put(`${BASE_URL + API_ENDPOINTS.product}/${idProduto}`, form);
      history.push("/produtos");
    }
    
  };

  return (
    <Form onSubmit={(e) => submeter(e)}>
      <Form.Group controlId="campoNome">
        <Form.Label>Nome</Form.Label>
        <Form.Control
          type="text"
          placeholder="Nome"
          value={form.name}
          onChange={(e) => setValor(e, "name")}
        />
      </Form.Group>
      <Form.Group controlId="campoPreco">
        <Form.Label>Preço</Form.Label>
        <Form.Control
          type="number"
          min="0"
          step="0.01"
          value={form.value}
          onChange={(e) => setValor(e, "value")}
        />
      </Form.Group>
      <Form.Group controlId="campoFoto">
        <Form.Label>Foto</Form.Label>
        <Form.Control
          type="text"
          placeholder="Foto"
          value={form.image}
          onChange={(e) => setValor(e, "image")}
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Gravar
      </Button>
      &nbsp;
      <Button
        variant="secondary"
        type="button"
        onChange={(e) => setValor(e, "image")}
      >
        Limpar
      </Button>
    </Form>
  );
}

export default FormProdutos;
